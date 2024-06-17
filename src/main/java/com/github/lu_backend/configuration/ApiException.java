package com.github.lu_backend.configuration;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {
    HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
