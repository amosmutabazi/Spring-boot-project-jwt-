package com.learning.cruddemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SchoolExceptionHandler {
    public ResponseEntity<Object> handleSchoolNotFoundException(SchoolNotFoundException schoolNotFoundException) {
        SchoolException schoolException = new SchoolException(
                schoolNotFoundException.getMessage(),
                schoolNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new  ResponseEntity<> (schoolException, HttpStatus.NOT_FOUND);
    }
}
