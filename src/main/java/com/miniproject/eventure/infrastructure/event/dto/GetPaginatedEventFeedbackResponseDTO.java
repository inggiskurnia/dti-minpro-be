package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventFeedback;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GetPaginatedEventFeedbackResponseDTO {
    private Long eventFeedbackId;
    private String eventName;
    private String eventTicketName;
    private String userFullName;
    private String userProfilePicture;
    private String feedback;
    private OffsetDateTime createdAt;

    public GetPaginatedEventFeedbackResponseDTO(EventFeedback eventFeedback){
        this.eventFeedbackId = eventFeedback.getEventFeedbackId();
        this.eventName = eventFeedback.getEventTicket().getEvent().getName();
        this.eventTicketName = eventFeedback.getEventTicket().getTicketName();
        this.userFullName = eventFeedback.getUser().getFullName();
        this.userProfilePicture = eventFeedback.getUser().getProfilePicture();
        this.feedback = eventFeedback.getFeedback();
        this.createdAt = eventFeedback.getCreatedAt();
    }
}
