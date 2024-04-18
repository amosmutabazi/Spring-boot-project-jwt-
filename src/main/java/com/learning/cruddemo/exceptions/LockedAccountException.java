package com.learning.cruddemo.exceptions;

public class LockedAccountException extends RuntimeException{



    public LockedAccountException(String message) {
        super(message);
    }
}
