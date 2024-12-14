package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import lombok.Data;

@Data
public class SearchEventResponseDTO {
    private Long eventId;
    private String eventName;

    public SearchEventResponseDTO(Event event){
        this.eventId = event.getEventId();
        this.eventName = event.getName();
    }
}
