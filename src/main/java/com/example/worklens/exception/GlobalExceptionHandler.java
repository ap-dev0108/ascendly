package com.example.worklens.exception;

import com.example.worklens.exception.custom.DuplicateResourceException;
import com.example.worklens.exception.custom.ForbiddenAccessException;
import com.example.worklens.exception.custom.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFound(ResourceNotFoundException ex) {
        return build(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(ForbiddenAccessException.class)
    public ResponseEntity<ExceptionResponse> handleForbidden(ForbiddenAccessException ex) {
        return build(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicate(DuplicateResourceException ex) {
        return build(ex.getStatus(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> InternalServerException(Exception ex) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<ExceptionResponse> build(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(new ExceptionResponse(
                    message,
                    status.value(),
                    LocalDateTime.now()
        ));
    }
}
