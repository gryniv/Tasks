package com.hospital.exception;

public class UnexpectedHealthCondition extends RuntimeException {
    public UnexpectedHealthCondition(final String message) {
        super(message);
    }
}
