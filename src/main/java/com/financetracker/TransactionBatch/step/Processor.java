package com.financetracker.TransactionBatch.step;

import com.financetracker.TransactionBatch.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.Random;

public class Processor implements ItemProcessor<Transaction, Transaction> {

    private static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        //Random r = new Random();

        return transaction;
    }
}
