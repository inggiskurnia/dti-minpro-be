package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;

public interface CreateEventReviewUseCase {
    EventReview createEventReview(Long evenTickettId, Long userId, CreateEventReviewRequestDTO req);
}
