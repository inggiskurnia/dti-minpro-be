package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.entity.event.EventReview;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEventReviewRequestDTO {
    @NotNull
    private Long eventId;

    @NotNull
    private Long userId;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    private String description;
}
