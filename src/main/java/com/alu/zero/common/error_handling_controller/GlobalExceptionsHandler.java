package com.alu.zero.common.error_handling_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alu.zero.common.exceptions.InternalServerErrorException;
import com.alu.zero.common.exceptions.NotFoundException;
import com.alu.zero.common.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionsHandler {
    
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ExceptionResponse> internalServerExceptionHandler(InternalServerErrorException internalServerErrorException){
        ExceptionResponse exceptionResponse = new ExceptionResponse(internalServerErrorException.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(NotFoundException notFoundException) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(notFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
