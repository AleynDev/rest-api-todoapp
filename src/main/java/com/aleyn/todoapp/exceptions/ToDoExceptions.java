package com.aleyn.todoapp.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * Custom exception showing a message and http status
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ToDoExceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}

