package com.learning.cruddemo.exceptions;

public class SchoolNotFoundException extends Exception {
    public SchoolNotFoundException(String message) {
        super(message);
    }

    public SchoolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
