package com.miniproject.eventure.infrastructure.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateEventFeedbackRequestDTO {

    @NotNull
    private Long eventId;

    @NotNull
    private Long userId;

    @Size(max = 1000)
    private String feedback;
}
