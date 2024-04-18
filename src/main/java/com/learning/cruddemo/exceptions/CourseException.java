package com.learning.cruddemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor

public class CourseException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
