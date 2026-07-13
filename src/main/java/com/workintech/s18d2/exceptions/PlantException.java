package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class PlantException extends RuntimeException {
    private final HttpStatus status;

    public PlantException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
