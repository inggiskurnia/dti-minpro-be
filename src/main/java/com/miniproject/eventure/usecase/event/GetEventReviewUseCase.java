package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventReviewResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface GetEventReviewUseCase {
    List<EventReview> getAllEventReview();
    Optional<EventReview> getAllEventReviewById(Long eventReviewId);
    PaginationInfo<GetPaginatedEventReviewResponseDTO> getPaginatedEventReview(Long eventId, PageRequest pageRequest);
}
