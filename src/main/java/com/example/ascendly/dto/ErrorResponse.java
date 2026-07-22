package com.example.ascendly.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse (
        String code,
        String message,
        int status,
        LocalDateTime time,
        String path,
        List<FieldError> errors
) {
    public record FieldError(String field, String message) {}
}
