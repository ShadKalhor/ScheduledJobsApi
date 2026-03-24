package com.example.ScheduledJobsApi.exception;


public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
