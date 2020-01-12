package com.sox.exceptions;

public class BelowMinimumBalanceException extends ExceedLimitException{
    public BelowMinimumBalanceException(String message) {
        super(message);
    }

}
