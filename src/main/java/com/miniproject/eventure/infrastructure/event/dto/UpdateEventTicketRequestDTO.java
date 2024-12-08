package com.miniproject.eventure.infrastructure.event.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UpdateEventTicketRequestDTO {
    private String ticketName;
    private Double price;
    private Integer totalCapacity;
    private Integer totalAvailable;
    private String description;
    private OffsetDateTime startedAt;
    private OffsetDateTime endedAt;
}
