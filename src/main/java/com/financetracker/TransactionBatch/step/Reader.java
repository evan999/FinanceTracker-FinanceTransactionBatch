package com.financetracker.TransactionBatch.step;

import com.financetracker.TransactionBatch.model.Transaction;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class Reader {
    public static FlatFileItemReader<Transaction> reader(String path) {
        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<Transaction>();

        reader.setResource(new ClassPathResource(path));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Transaction>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames("step", "type", "amount",
                                "nameOrig", "oldbalanceOrig", "newbalanceOrig", "nameDest", "oldbalanceDest", "newbalanceDest",
                                "isFraud", "isFlaggedFraud");
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>() {
                    {
                        setTargetType(Transaction.class);
                    }
                });
            }
        });
        return reader;
    }

}
