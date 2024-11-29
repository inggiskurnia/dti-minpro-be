package com.miniproject.eventure.common.exeptions;

public class DuplicateRequestDataException extends RuntimeException {
    public DuplicateRequestDataException(String message) {
        super(message);
    }
}
