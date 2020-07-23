package com.financetracker.TransactionBatch.config;

import com.financetracker.TransactionBatch.Dao.TransactionDao;
import com.financetracker.TransactionBatch.model.Transaction;
import com.financetracker.TransactionBatch.step.Listener;
import com.financetracker.TransactionBatch.step.Processor;
import com.financetracker.TransactionBatch.step.Reader;
import com.financetracker.TransactionBatch.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.MapJobExecutionDao;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public TransactionDao transactionDao;

    private static final int CHUNK_SIZE = 200000;
    private static final int CONCURRENCY_LIMIT = 5;
    private static final int THROTTLE_LIMIT = 20;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(transactionDao))
                .flow(step1()).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor("spring_batch");
        asyncTaskExecutor.setConcurrencyLimit(CONCURRENCY_LIMIT);
        return asyncTaskExecutor;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Transaction, Transaction>chunk(CHUNK_SIZE)
                .reader(Reader.reader("PS_20174392719_1491204439457_log.csv"))
                .processor(new Processor())
                .writer(new Writer(transactionDao))
                .taskExecutor(taskExecutor())
                .throttleLimit(THROTTLE_LIMIT)
                .build();

    }
}
