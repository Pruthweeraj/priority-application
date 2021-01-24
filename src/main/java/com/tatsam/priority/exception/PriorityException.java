package com.tatsam.priority.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PriorityException extends ResponseStatusException {

    private static final long serialVersionUID = -4246816149402568602L;

    public PriorityException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }


}

