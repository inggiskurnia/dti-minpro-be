package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventFeedbackResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface GetEventFeedbackUseCase {
    List<EventFeedback> getAllEventFeedback();
    EventFeedback getEventFeedbackById(Long eventFeedbackId);
    PaginationInfo<GetPaginatedEventFeedbackResponseDTO> getPaginatedEvent(Long eventId, PageRequest pageRequest);

}
