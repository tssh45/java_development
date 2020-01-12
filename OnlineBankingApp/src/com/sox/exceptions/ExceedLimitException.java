package com.sox.exceptions;

public class ExceedLimitException extends TransactionAbortedException{
    public ExceedLimitException(String message) {
        super(message);
    }
}
