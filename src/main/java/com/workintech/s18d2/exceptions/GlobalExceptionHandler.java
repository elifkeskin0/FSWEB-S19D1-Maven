package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handlePlantException(PlantException exception) {
        log.error(exception.getMessage(), exception);
        PlantErrorResponse response = new PlantErrorResponse(
                exception.getMessage(),
                exception.getStatus().value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        PlantErrorResponse response = new PlantErrorResponse(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
