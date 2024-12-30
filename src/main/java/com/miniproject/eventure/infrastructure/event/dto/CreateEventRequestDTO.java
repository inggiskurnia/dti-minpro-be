package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateEventRequestDTO {

    @NotNull(message = "Organizer ID is required")
    private Long organizerId;

    @NotNull(message = "Event name is required")
    @Size(max = 100, message = "Event name must not exceed 100 characters")
    private String name;

    @NotNull(message = "Description is required")
    private String description;

    @NotNull(message = "Thumbnail is required")
    private String thumbnail;

    private Long eventCategoryId;

    private Long cityId;

    @NotNull(message = "Location details are required")
    private String locationDetail;

    @NotNull(message = "Start date and time are required")
    private OffsetDateTime startedAt;

    @NotNull(message = "End date and time are required")
    private OffsetDateTime endedAt;

    @NotNull(message = "Total capacity is required")
    @Min(value = 0, message = "Total capacity must be at least 0")
    private Integer totalCapacity;

    @NotNull(message = "Total available seats are required")
    @Min(value = 0, message = "Total available seats must be at least 0")
    private Integer totalAvailable;

    public Event toEntity(){
        Event event = new Event();

        event.setName(name);
        event.setDescription(description);
        event.setThumbnail(thumbnail);
        event.setLocationDetail(locationDetail);
        event.setStartedAt(startedAt);
        event.setEndedAt(endedAt);
        event.setTotalCapacity(totalCapacity);
        event.setTotalAvailable(totalAvailable);
        event.setCreatedAt(OffsetDateTime.now());

        return event;
    }
}

