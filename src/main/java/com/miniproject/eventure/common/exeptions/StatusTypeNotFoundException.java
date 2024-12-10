package com.miniproject.eventure.common.exeptions;

public class StatusTypeNotFoundException extends RuntimeException {
    public StatusTypeNotFoundException(Long statusTypeId) {
        super("Status type with ID " + statusTypeId + " not found !");
    }
}
