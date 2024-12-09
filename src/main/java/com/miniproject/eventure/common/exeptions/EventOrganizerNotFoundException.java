package com.miniproject.eventure.common.exeptions;

public class EventOrganizerNotFoundException extends RuntimeException {
    public EventOrganizerNotFoundException(Long eventOrganizerId) {
        super("Event organizer with Id " + eventOrganizerId + " not found !");
    }
}
