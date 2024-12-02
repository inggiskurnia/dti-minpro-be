package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventRequestDTO;

public interface CreateEventUseCase {
    Event createEvent(CreateEventRequestDTO req);
}
