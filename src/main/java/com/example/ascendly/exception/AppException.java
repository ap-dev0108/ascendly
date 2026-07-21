package com.example.ascendly.exception;

import org.springframework.http.HttpStatus;

public abstract class AppException extends RuntimeException{
    private final String code;
    private final HttpStatus status;

    protected AppException(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }
    public HttpStatus getStatus() {
        return status;
    }

    public class ResourceNotFoundException extends AppException{
        public ResourceNotFoundException(String message) {
            super("RESOURCES_NOT_FOUND" ,HttpStatus.NOT_FOUND);
        }
    }

    public class DuplicateResourceException extends AppException {
        public DuplicateResourceException(String message) {
            super("RESOURCES_DUPLICATED", HttpStatus.CONFLICT);
        }
    }
}
