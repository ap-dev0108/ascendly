package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;

public class ForbiddenAccessException extends AppException {
    public ForbiddenAccessException(String message) {
        super(message);
    }
}
