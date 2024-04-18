package com.learning.cruddemo.exceptions;

import com.learning.cruddemo.models.Course;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@ResponseStatus
public class CourseExceptionHandler {
    @ExceptionHandler(CourseNotFoundException.class)

    public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException courseNotFoundException) {
        CourseException courseException = new CourseException(
                courseNotFoundException.getMessage(),
                courseNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(courseException, HttpStatus.NOT_FOUND);

    }
}
