package com.miniproject.eventure.infrastructure.event.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEventReviewRequestDTO {

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    private String description;
}
