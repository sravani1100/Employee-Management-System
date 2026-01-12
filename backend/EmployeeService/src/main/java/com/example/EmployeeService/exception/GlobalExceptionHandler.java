package com.example.EmployeeService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> notFoundException(EmployeeNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee not found");
    }
}
