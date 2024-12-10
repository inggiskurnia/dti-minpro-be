package com.miniproject.eventure.common.exeptions;

public class EventTicketNotFoundException extends RuntimeException {
    public EventTicketNotFoundException(Long eventTicketID) {
        super("Event ticket with ID " + eventTicketID + " not found !");
    }
}
