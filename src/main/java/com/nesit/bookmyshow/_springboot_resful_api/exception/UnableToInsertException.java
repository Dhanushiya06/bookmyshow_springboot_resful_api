package com.nesit.bookmyshow._springboot_resful_api.exception;

public class UnableToInsertException extends RuntimeException {
    public UnableToInsertException(String msg) {
        super(msg);
    }
}