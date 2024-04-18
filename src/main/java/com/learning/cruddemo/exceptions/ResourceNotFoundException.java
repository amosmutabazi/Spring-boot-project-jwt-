package com.learning.cruddemo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private final Date timestamp;
    private Object[] args;

    public ResourceNotFoundException(String message, Object... args) {
        super(message);
        this.args = args;
        this.timestamp = new Date();
    }

}

