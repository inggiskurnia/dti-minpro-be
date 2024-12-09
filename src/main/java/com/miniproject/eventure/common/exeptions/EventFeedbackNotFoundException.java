package com.miniproject.eventure.common.exeptions;

public class EventFeedbackNotFoundException extends RuntimeException {
    public EventFeedbackNotFoundException() {
        super("Event feedback not found !");
    }
}
