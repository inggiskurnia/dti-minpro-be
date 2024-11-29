package com.miniproject.eventure.common.exeptions;

public class EmptyRequestDataException extends RuntimeException {
    public EmptyRequestDataException(String message) {
        super(message);
    }
}
