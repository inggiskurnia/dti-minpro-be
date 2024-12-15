package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.UserTicket;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GetUserTicketResponseDTO {
    private Long userTicketId;
    private Long userId;
    private Long eventTicketId;
    private String eventTicketName;
    private String eventTicketDescription;
    private Integer totalTicket;
    private Long eventId;
    private OffsetDateTime eventStartedAt;
    private OffsetDateTime eventEndedAt;
    private String eventName;
    private String eventLocationDetail;
    private OffsetDateTime purchasedAt;

    public GetUserTicketResponseDTO(UserTicket userTicket){
        this.userTicketId = userTicket.getUserTicketId();
        this.userId = userTicket.getUser().getUserId();
        this.eventTicketId = userTicket.getEventTicket().getEventTicketId();
        this.eventTicketName = userTicket.getEventTicket().getTicketName();
        this.eventTicketDescription = userTicket.getEventTicket().getDescription();
        this.totalTicket = userTicket.getTotalTicket();
        this.eventId = userTicket.getEventTicket().getEvent().getEventId();
        this.eventStartedAt = userTicket.getEventTicket().getStartedAt();
        this.eventEndedAt = userTicket.getEventTicket().getEndedAt();
        this.eventName =userTicket.getEventTicket().getEvent().getName();
        this.eventLocationDetail = userTicket.getEventTicket().getEvent().getLocationDetail();
        this.purchasedAt = userTicket.getCreatedAt();

    }
}
