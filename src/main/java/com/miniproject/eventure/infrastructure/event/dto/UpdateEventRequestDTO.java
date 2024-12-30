package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class UpdateEventRequestDTO {

    private Long organizerId;

    @Size(max = 100)
    private String name;

    @Max(2000)
    private String description;

    private String thumbnail;
    private Long eventCategoryId;
    private Long cityId;
    private String locationDetail;
    private Double longitude;
    private Double latitude;
    private OffsetDateTime startedAt;
    private OffsetDateTime endedAt;

    @Min(0)
    private Integer totalCapacity;

    @Min(0)
    private Integer totalAvailable;

    public Event toEntity(){
        Event event = new Event();

        event.setName(name);
        event.setDescription(description);
        event.setThumbnail(thumbnail);
        event.setLocationDetail(thumbnail);
        event.setStartedAt(startedAt);
        event.setEndedAt(endedAt);
        event.setTotalCapacity(totalCapacity);
        event.setTotalAvailable(totalAvailable);

        return event;
    }
}
