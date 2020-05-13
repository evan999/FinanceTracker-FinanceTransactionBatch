package com.financetracker.TransactionBatch.model;

public class Transaction {
    //private long transaction_id;
    private int step;
    private String type;
    private float amount;
    private String nameOrig;
    private float oldbalanceOrig;
    private float newbalanceOrig;
    private String nameDest;
    private float oldbalanceDest;
    private float newbalanceDest;
    private int isFraud;
    private int isFlaggedFraud;
    //private Date createdAt;
    private String time;

    public Transaction(int step, String type, float amount,
                       String nameOrig, float oldbalanceOrig, float newbalanceOrig,
                       String nameDest, float oldbalanceDest, float newbalanceDest,
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public float getOldbalanceOrig() {
        return oldbalanceOrig;
    }

    public void setOldbalanceOrig(float oldbalanceOrig) {
        this.oldbalanceOrig = oldbalanceOrig;
    }

    public float getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(float newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = this.nameDest;
    }

    public void setOldbalanceDest(float oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public float getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setNewbalanceDest(float newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    public float getNewbalanceDest() {
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
        return String.format("Transaction[step='%d', type='%s', amount='%f', nameOrig='%s', oldbalanceOrig='%f', " +
                "newbalanceOrig='%f', nameDest='%s', oldbalanceDest='%f', newbalanceDest='%f', isFraud='%d', isFlaggedFraud='%d']",
                step, type, amount, nameOrig, oldbalanceOrig, newbalanceOrig, nameDest, oldbalanceDest,
                newbalanceDest, isFraud, isFlaggedFraud);
    }
}
