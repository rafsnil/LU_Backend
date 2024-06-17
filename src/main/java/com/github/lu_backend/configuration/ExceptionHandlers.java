package com.github.lu_backend.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleException(ApiException ex) {
        return ResponseEntity.status(ex.httpStatus)
                .body(Map.of("error", Map.of("name", "api exception", "status", ex.httpStatus, "message", ex.getMessage())));
    }
}

