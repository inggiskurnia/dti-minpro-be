package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventPicture;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEventPictureRequestDTO {
    @NotNull
    private Long eventId;

    @NotNull
    @Max(1000)
    private String eventPictureUrl;

    public EventPicture toEntity(Event event){
        EventPicture eventPicture = new EventPicture();
        eventPicture.setEvent(event);
        eventPicture.setEventPictureUrl(eventPictureUrl);
        return eventPicture;
    }
}
