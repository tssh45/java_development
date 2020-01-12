package com.sox.exceptions;

public class OverDraftLimitExceededException extends ExceedLimitException {
    public OverDraftLimitExceededException(String message) {
        super(message);
    }
}
