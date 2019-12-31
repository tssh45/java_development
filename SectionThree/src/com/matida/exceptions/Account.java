package com.matida.exceptions;

public class Account {
    private float balance;



    public  void withdrawal(float value) throws AccountException{
        if (value > balance)
            throw new AccountException(new InsufficientFundsException());
    }

    public  void deposit(float value) {
        if (value <= 0)
            throw new IllegalArgumentException();
    }
}