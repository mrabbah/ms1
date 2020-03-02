package com.example.ms1.web.rest.errors;

import java.net.URI;

public final class ErrorConstants {

    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "https://stackoverflow.com";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL);
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL);

    private ErrorConstants() {
    }
}
