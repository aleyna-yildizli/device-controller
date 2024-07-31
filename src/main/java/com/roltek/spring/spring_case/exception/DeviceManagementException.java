package com.roltek.spring.spring_case.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DeviceManagementException extends RuntimeException {
    private HttpStatus httpStatus;
    public DeviceManagementException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
