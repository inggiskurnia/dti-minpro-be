package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventRequestDTO;

public interface UpdateEventUseCase {
    Event updateEvent(Long id, UpdateEventRequestDTO req);
}
