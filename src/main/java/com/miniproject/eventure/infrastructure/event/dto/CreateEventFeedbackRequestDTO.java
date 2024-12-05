package com.miniproject.eventure.infrastructure.event.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateEventFeedbackRequestDTO {

    @Size(max = 1000)
    private String feedback;
}
