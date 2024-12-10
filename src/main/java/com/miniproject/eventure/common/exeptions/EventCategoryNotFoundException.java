package com.miniproject.eventure.common.exeptions;

public class EventCategoryNotFoundException extends RuntimeException {
    public EventCategoryNotFoundException(Long eventCategoryId) {
        super("Event category with Id " + eventCategoryId + " not found !");
    }
}
