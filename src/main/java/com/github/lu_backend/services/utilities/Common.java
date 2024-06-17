package com.github.lu_backend.services.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class Common {
    public static ResponseEntity<?> sendResponse(HttpStatus httpStatus, String message, Object data) {
        return ResponseEntity.status(httpStatus).body(Map.of("status", httpStatus.value(), "message", message, "data", data));
    }
}
