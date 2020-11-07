package com.hospital.exception;

public class UnknownHealthConditionException extends RuntimeException {
    public UnknownHealthConditionException(final String message) {
        super(message);
    }
}
