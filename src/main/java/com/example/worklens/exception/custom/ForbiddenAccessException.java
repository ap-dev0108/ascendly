package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;
import org.springframework.http.HttpStatus;

public class ForbiddenAccessException extends AppException {
    public ForbiddenAccessException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
