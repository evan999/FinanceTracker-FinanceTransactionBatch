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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public TransactionDao transactionDao;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(transactionDao))
                .flow(step1()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Transaction, Transaction>chunk(100)
                .reader(Reader.reader("transaction_dataset.csv"))
                .processor(new Processor()).writer(new Writer(transactionDao)).build();
    }
}
