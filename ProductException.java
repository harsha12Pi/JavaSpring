package com.SpringWebApp.SpringWebApp.Exception;

import org.springframework.http.HttpStatus;

public class ProductException {
    private String message;
    private HttpStatus status;
    private Throwable cause;

    // Constructors
    public ProductException(String message, HttpStatus status, Throwable cause) {
        this.message = message;
        this.status = status;
        this.cause = cause;
    }

    // Getters & setters (important for JSON serialization)
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Throwable getCause() {
        return cause;
    }
}
