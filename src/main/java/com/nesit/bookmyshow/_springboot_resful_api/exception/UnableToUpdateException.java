package com.nesit.bookmyshow._springboot_resful_api.exception;

public class UnableToUpdateException extends RuntimeException {
    public UnableToUpdateException(String msg) {
        super(msg);
    }
}