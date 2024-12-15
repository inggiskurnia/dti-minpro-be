package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventFeedbackRequestDTO;

public interface CreateEventFeedbackUseCase {
    EventFeedback createEventFeedback(Long ticketId, Long userId, CreateEventFeedbackRequestDTO req);
}
