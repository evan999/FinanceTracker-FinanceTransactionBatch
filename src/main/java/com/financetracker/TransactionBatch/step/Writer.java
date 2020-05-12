package com.financetracker.TransactionBatch.step;

import com.financetracker.TransactionBatch.Dao.TransactionDao;
import com.financetracker.TransactionBatch.model.Transaction;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<Transaction> {

    private final TransactionDao transactionDao;

    public Writer(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void write(List<? extends Transaction> transactions) throws Exception {
        transactionDao.insert(transactions);
    }
}
