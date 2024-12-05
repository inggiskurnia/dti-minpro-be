package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class GetPaginatedEventResponseDTO {
    private Long eventId;
    private String organizer;
    private String name;
    private String thumbnail;
    private BigDecimal startingPrice;
    private OffsetDateTime startedAt;

    public GetPaginatedEventResponseDTO(Event event){
        this.eventId = event.getEventId();
        this.organizer = event.getOrganizer().getFullName();
        this.name = event.getName();
        this.thumbnail = event.getThumbnail();
        this.startingPrice = event.getStartingPrice();
        this.startedAt = event.getStartedAt();
    }
}
