package com.financetracker.TransactionBatch.Dao;

import com.financetracker.TransactionBatch.model.Transaction;

import java.util.List;

public interface TransactionDao {
    public void insert(List<? extends Transaction> transactions);
    List<Transaction> loadAllTransactions();
}
