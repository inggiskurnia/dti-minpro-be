package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventOrganizerRequestDTO;

public interface CreateEventOrganizerUseCase {
    EventOrganizer createEventOrganizer(CreateEventOrganizerRequestDTO req);
}
