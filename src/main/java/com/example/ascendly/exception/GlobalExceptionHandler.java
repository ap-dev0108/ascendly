package com.example.ascendly.exception;

import com.example.ascendly.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> HandleException(AppException app, HttpServletRequest request) {
        log.error("Handled Exception: {} - {}", app.getCode(), app.getMessage());
        return build(app.getStatus(), app.getCode(), app.getMessage(), request, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<ErrorResponse.FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ErrorResponse.FieldError(fe.getField(), fe.getDefaultMessage())).toList();

        return build(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", "VALIDATION_FAILED", request, fieldErrorList);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> HandleUnexpected(Exception ex, HttpServletRequest request) {
        log.error("Unexpected Error", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_ERROR",
                "An unexpected error occured",
                request,
                null);
    }


    private ResponseEntity<ErrorResponse> build(HttpStatus status, String code, String message,
                                                HttpServletRequest request, List<ErrorResponse.FieldError> fieldErrorList) {
        ErrorResponse body = new ErrorResponse(code, message, status.value(), LocalDateTime.now(), request.getRequestURI(), fieldErrorList);

        return ResponseEntity.status(status).body(body);
    }
}
