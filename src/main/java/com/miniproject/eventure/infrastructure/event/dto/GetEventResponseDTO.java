package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventOrganizer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class GetEventResponseDTO {

    private Long eventId;
    private EventOrganizer organizer;
    private String organizerName;
    private String organizerProfilePicture;
    private String name;
    private String description;
    private String thumbnail;
    private String eventCategoryName;
    private String cityName;
    private String locationDetail;
    private Double longitude;
    private Double latitude;
    private OffsetDateTime startedAt;
    private OffsetDateTime endedAt;
    private BigDecimal startingPrice;
    private Integer totalCapacity;
    private Integer totalAvailable;

    public GetEventResponseDTO(Event event) {
        this.eventId = event.getEventId();
        this.organizer = event.getOrganizer();
        this.organizerName = event.getOrganizer().getName();
        this.organizerProfilePicture = event.getOrganizer().getProfilePictureLink();
        this.name = event.getName();
        this.description = event.getDescription();
        this.thumbnail = event.getThumbnail();
        this.eventCategoryName = event.getEventCategory().getName();
        this.cityName = event.getCity().getName();
        this.locationDetail = event.getLocationDetail();
        this.startedAt = event.getStartedAt();
        this.endedAt = event.getEndedAt();
        this.startingPrice = event.getStartingPrice();
        this.totalCapacity = event.getTotalCapacity();
        this.totalAvailable = event.getTotalAvailable();
    }
}
