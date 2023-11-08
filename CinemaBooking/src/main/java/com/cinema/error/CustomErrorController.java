package com.cinema.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CustomErrorController {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Log the error for debugging purposes
        e.printStackTrace();

        // Return a custom error message and HTTP status code
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}
