package com.learning.cruddemo.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
