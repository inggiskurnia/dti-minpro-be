package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventTicket;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateEventTicketRequestDTO {
    @NotNull
    private Long eventId;

    @NotNull
    private String ticketName;

    @NotNull
    private Double price;

    @NotNull
    @Min(0)
    private Integer totalCapacity;

    @NotNull
    @Min(0)
    private Integer totalAvailable;

    private String description;

    @NotNull
    private OffsetDateTime startedAt;

    @NotNull
    private OffsetDateTime endedAt;


    public EventTicket toEntity(Event event){
        EventTicket eventTicket = new EventTicket();
        eventTicket.setEvent(event);
        eventTicket.setTicketName(ticketName);
        eventTicket.setPrice(price);
        eventTicket.setTotalCapacity(totalCapacity);
        eventTicket.setTotalAvailable(totalAvailable);
        eventTicket.setDescription(description);
        eventTicket.setStartedAt(startedAt);
        eventTicket.setEndedAt(endedAt);

        return eventTicket;
    }
}

