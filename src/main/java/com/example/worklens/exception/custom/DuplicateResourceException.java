package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;

public class DuplicateResourceException extends AppException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}
