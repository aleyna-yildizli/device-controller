package com.roltek.spring.spring_case.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(DeviceManagementException deviceManagementException) {
        ErrorResponse errorResponse = new ErrorResponse(deviceManagementException.getMessage(),
                Instant.now());
        return new ResponseEntity<>(errorResponse, deviceManagementException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),
                Instant.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
