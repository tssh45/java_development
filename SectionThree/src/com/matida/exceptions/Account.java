package com.matida.exceptions;

public class Account {
    private float balance;

    public Account(float balance) {
        this.balance = balance;
        //balance = 0;
    }

    public void deposit(float value) {
        if (value <= 0)
            throw new IllegalArgumentException();
    }

    public void withdraw(float value) throws AccountException{
        if (value > balance)
            throw new AccountException(new InsufficientFundsException());
    }
}