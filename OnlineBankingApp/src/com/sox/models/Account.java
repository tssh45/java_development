package com.sox.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Cloneable, Serializable {
    private int account_id;
    private int pin;
    private double amount;
    private int accountType;
    private int bankBranchId;

    private ArrayList<Customer> customers;
    private BankBranch bankBranch;
    private boolean jointAccount;

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public boolean isJointAccount() {
        return jointAccount;
    }


    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public void setJointAccount(boolean jointAccount) {
        this.jointAccount = jointAccount;
    }

    public Account () {
        customers = new ArrayList<Customer>();
    }

    public Account (int accountIdIn) {
        this.account_id = accountIdIn;
    }

    public int getAccount_id() {
        return this.account_id;
    }

    public int getPin() {
        return this.pin;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public int getBankBranchId() {
        return this.bankBranchId;
    }

    public void setAccount_id(int accountIdIn) {
        this.account_id = accountIdIn;
    }

    public void setPin(int pinIn) {
        this.pin = pinIn;
    }

    public void setAmount(double f) {
        this.amount = f;
    }

    public void setAccountType(int accountTypeIn) {
        this.accountType = accountTypeIn;
    }

    public void setBankBranchId(int bankBranchIdIn) {
        this.bankBranchId = bankBranchIdIn;
    }

    public void setAll(
            int accountIdIn,
            int pinIn,
            long amountIn,
            int accountTypeIn,
            int bankBranchIdIn) {

            this.account_id = accountIdIn;
            this.pin = pinIn;
            this.amount = amountIn;
            this.accountType = accountTypeIn;
            this.bankBranchId = bankBranchIdIn;
    }

    public boolean hasEqualMapping(Account valueObject) {
        if (valueObject.getAccount_id() != account_id) {
            return false;
        }
        if (valueObject.getPin() != this.pin) {
            return false;
        }

        if (valueObject.getAmount() != this.amount) {
            return false;
        }
        if (valueObject.getAccountType() != this.accountType) {
            return false;
        }
        if (valueObject.getBankBranchId() != this.bankBranchId) {
            return false;
        }

        return true;

    }

    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Account, mapping to table account\n");
        out.append("Persistent attributes: \n");
        out.append("account_id = " + this.account_id + "\n");
        out.append("pin = " + this.pin + "\n");
        out.append("amount = " + this.amount + "\n");
        out.append("account_type = " + this.accountType + "\n");
        out.append("bank_branch_id = " + this.bankBranchId + "\n");
        return out.toString();
    }

    public Object clone() {
        Account cloned = new Account();

        cloned.setAccount_id(this.account_id);
        cloned.setPin(this.pin);
        cloned.setAmount(this.amount);
        cloned.setAccountType(this.accountType);
        cloned.setBankBranch(this.bankBranch);
        return cloned;

    }

    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

