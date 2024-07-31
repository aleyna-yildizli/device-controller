package com.roltek.spring.spring_case.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Instant timestamp;
}
