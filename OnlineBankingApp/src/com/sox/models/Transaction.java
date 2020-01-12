package com.sox.models;

import java.io.Serializable;
import java.sql.Timestamp;


public class Transaction implements Cloneable, Serializable {
    private int transcactionId;
    private int customerId;
    private int accountId;
    private int accountIdTo;
    private int transactionType;
    private double transactionAmount;
    private Timestamp transactionTime;

    public Transaction() {

    }

    public Transaction(int transcactionIdIn) {
        this.transcactionId = transcactionIdIn;
    }

    public int getTranscactionId() {
        return this.transcactionId;
    }

    public void setTranscactionId(int transcactionIdIn) {
        this.transcactionId = transcactionIdIn;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerIdIn) {
        this.customerId = customerIdIn;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountIdIn) {
        this.accountId = accountIdIn;
    }

    public int getAccountIdTo() {
        return this.accountIdTo;
    }

    public void setAccountIdTo(int accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public int getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(int transactionTypeIn) {
        this.transactionType = transactionTypeIn;
    }

    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(double transactionAmountIn) {
        this.transactionAmount = transactionAmountIn;
    }

    public Timestamp getTransactionTime() {
        return this.transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTimeIn) {
        this.transactionTime = transactionTimeIn;
    }

    public void setAll(
            int transcactionIdIn,
            int customerIdIn,
            int accountIdIn,
            int accountIdToIn,
            int transactionTypeIn,
            double transactionAmountIn,
            Timestamp transactionTimeIn) {

        this.transcactionId = transcactionIdIn;
        this.customerId = customerIdIn;
        this.accountId = accountIdIn;
        this.accountIdTo = accountIdToIn;
        this.transactionType = transactionTypeIn;
        this.transactionAmount = transactionAmountIn;
        this.transactionTime = transactionTimeIn;
    }

    public boolean hasEqualMapping(Transaction valueObject) {
        if (valueObject.getTranscactionId() != this.transcactionId) {
            return false;
        }

        if (valueObject.getCustomerId() != this.customerId) {
            return false;
        }

        if (valueObject.getAccountId() != this.accountId) {
            return false;
        }

        if (valueObject.getAccountIdTo() != this.accountIdTo) {
            return false;
        }
        if (valueObject.getTransactionType() != this.transactionType) {
            return false;
        }

        if (valueObject.getTransactionAmount() != this.transactionAmount) {
            return false;
        }

        if (valueObject.getTransactionTime() != this.transactionTime) {
            return false;
        }
        return true;

    }


    /**
     * toString will return String object representing the state of this
     * valueObject. This is useful during application development, and possibly
     * when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Transaction, mapping to table transaction\n");
        out.append("Persistent attributes: \n");
        out.append("transaction_id = " + this.transcactionId + "\n");
        out.append("customer_id_by = " + this.customerId + "\n");
        out.append("account_id = " + this.accountId + "\n");
        out.append("account_id_to = " + this.accountIdTo + "\n");
        out.append("transaction_type = " + this.transactionType + "\n");
        out.append("transaction_amount = " + this.transactionAmount + "\n");
        out.append("transaction_time = " + this.transactionTime + "\n");
        return out.toString();
    }

    public Object clone() {
        Transaction cloned = new Transaction();

        cloned.setTranscactionId(this.transcactionId);
        cloned.setCustomerId(this.customerId);
        cloned.setAccountId(this.accountId);
        cloned.setAccountIdTo(this.accountIdTo);
        cloned.setTransactionType(this.transactionType);
        cloned.setTransactionAmount(this.transactionAmount);
        cloned.setTransactionTime(this.transactionTime);

        return cloned;
    }

    /**
     * getDaogenVersion will return information about generator which created
     * these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }



}
