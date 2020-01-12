package com.sox.exceptions;

public class NotEnoughtCashInBalanceException extends TransactionAbortedException {
    public NotEnoughtCashInBalanceException(String message) {
        super(message);
    }
}
