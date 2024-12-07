package com.miniproject.eventure.infrastructure.event.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEventOrganizerRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private String eventOrganizerName;

    private Long cityId;
    private String description;
    private String profilePictureLink;
}
