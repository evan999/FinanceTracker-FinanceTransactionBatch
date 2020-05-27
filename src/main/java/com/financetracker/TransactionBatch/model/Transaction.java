package com.financetracker.TransactionBatch.model;

public class Transaction {
    //private long transaction_id;
    private int step;
    private String type;
    private double amount;
    private String nameOrig;
    private double oldbalanceOrig;
    private double newbalanceOrig;
    private String nameDest;
    private double oldbalanceDest;
    private double newbalanceDest;
    private int isFraud;
    private int isFlaggedFraud;
    //private Date createdAt;
    //private String time;

    public Transaction(int step, String type, double amount,
                       String nameOrig, double oldbalanceOrig, double newbalanceOrig,
                       String nameDest, double oldbalanceDest, double newbalanceDest,
                       int isFraud, int isFlaggedFraud) {

        //this.transaction_id = transaction_id;
        this.step = step;
        this.type = type;
        this.amount = amount;
        this.nameOrig = nameOrig;
        this.oldbalanceOrig = oldbalanceOrig;
        this.newbalanceOrig = newbalanceOrig;
        this.nameDest = nameDest;
        this.oldbalanceDest = oldbalanceDest;
        this.newbalanceDest = newbalanceDest;
        this.isFraud = isFraud;
        this.isFlaggedFraud = isFlaggedFraud;
        //this.createdAt = createdAt;
    }

    public Transaction() {

    }

    /*
    public long getId() {
        return transaction_id;
    }

    public void setId(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    */

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public double getOldbalanceOrig() {
        return oldbalanceOrig;
    }

    public void setOldbalanceOrig(double oldbalanceOrig) {
        this.oldbalanceOrig = oldbalanceOrig;
    }

    public double getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(double newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = this.nameDest;
    }

    public void setOldbalanceDest(double oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public double getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setNewbalanceDest(double newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    public double getNewbalanceDest() {
        return newbalanceDest;
    }

    public int getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(int isFraud) {
        this.isFraud = isFraud;
    }

    public int getIsFlaggedFraud() {
        return isFlaggedFraud;
    }

    public void setIsFlaggedFraud(int isFlaggedFraud) {
        this.isFlaggedFraud = isFlaggedFraud;
    }

    @Override
    public String toString() {
        return String.format("Transaction[step='%d', type='%s', amount='%.2f', nameOrig='%s', oldbalanceOrig='%.2f', " +
                "newbalanceOrig='%.2f', nameDest='%s', oldbalanceDest='%.2f', newbalanceDest='%.2f', isFraud='%d', isFlaggedFraud='%d']",
                step, type, amount, nameOrig, oldbalanceOrig, newbalanceOrig, nameDest, oldbalanceDest,
                newbalanceDest, isFraud, isFlaggedFraud);
    }
}
