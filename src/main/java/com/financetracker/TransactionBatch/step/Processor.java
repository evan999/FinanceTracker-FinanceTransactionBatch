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
        /*
        Random r = new Random();
        final int step = transaction.getStep();
        final String type = transaction.getType().toUpperCase();
        final float amount = transaction.getAmount();
        final String nameOrig = transaction.getNameOrig().toUpperCase();
        final float oldbalanceOrig = transaction.getOldbalanceOrig();
        final float newbalanceOrig = transaction.getNewbalanceOrig();
        //final String nameDest = transaction.getNameDest().toUpperCase();
        final float oldbalanceDest = transaction.getOldbalanceDest();
        final float newbalanceDest = transaction.getNewbalanceDest();
        final int isFraud = transaction.getIsFraud();
        final int isFlaggedFraud = transaction.getIsFlaggedFraud();

        final Transaction convertedTransaction = new Transaction(step, type, amount, nameOrig, oldbalanceOrig,
                newbalanceOrig, nameDest, oldbalanceDest, newbalanceDest, isFraud, isFlaggedFraud);

        log.info("Converting " + transaction + " into " + convertedTransaction + ".");
         */

        //return convertedTransaction;
        return transaction;
    }
}
