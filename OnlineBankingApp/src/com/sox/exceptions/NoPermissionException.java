package com.sox.exceptions;

public class NoPermissionException extends  TransactionAbortedException {
    public NoPermissionException(String message) {
        super(message);
    }
}
