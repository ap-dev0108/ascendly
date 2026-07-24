package com.example.worklens.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public record ExceptionResponse (
        String message,
        HttpStatus status,
        LocalDateTime timestamp
) {}