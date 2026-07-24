package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;

public class InternalServerError extends AppException {
    public InternalServerError(String message) {
        super(message);
    }
}
