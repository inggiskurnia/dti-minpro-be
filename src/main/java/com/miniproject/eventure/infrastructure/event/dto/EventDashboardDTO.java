package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventOrganizer;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class EventDashboardDTO {

    private Long eventId;
    private EventOrganizer organizer;
    private String eventName;
    private String eventDescription;
    private int totalTicketsSold;
    private BigDecimal totalRevenue;

    // Constructor to initialize DTO with required fields
    public EventDashboardDTO(
            Long eventId,
            String eventName,
            String eventDescription,
            int totalTicketsSold,
            BigDecimal totalRevenue
    ) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.totalTicketsSold = totalTicketsSold;
        this.totalRevenue = totalRevenue;
    }
}
