package com.example.ScheduledJobsApi.exception;

import lombok.Getter;

import static com.example.ScheduledJobsApi.exception.ErrorTypeToHttpStatusMapper.httpStatus;

@Getter
public class ErrorStructureException extends RuntimeException {


    private final int httpStatus;

    private final String message;

    public ErrorStructureException(StructuredError structuredError) {
        this.httpStatus = httpStatus(structuredError.type());
        this.message = structuredError.message();
    }
}