package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;
import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends AppException {
    public DuplicateResourceException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
