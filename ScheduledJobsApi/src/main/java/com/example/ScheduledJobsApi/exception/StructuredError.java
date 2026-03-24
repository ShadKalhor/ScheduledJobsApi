package com.example.ScheduledJobsApi.exception;

public record StructuredError(String message, ErrorType type) {
}
