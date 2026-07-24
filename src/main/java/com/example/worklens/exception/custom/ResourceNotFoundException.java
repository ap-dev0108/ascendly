package com.example.worklens.exception.custom;

import com.example.worklens.exception.AppException;

public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
