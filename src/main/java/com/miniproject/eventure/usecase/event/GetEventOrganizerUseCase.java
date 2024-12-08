package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.infrastructure.event.dto.GetEventOrganizerResponseDTO;

public interface GetEventOrganizerUseCase {
    GetEventOrganizerResponseDTO getEventOrganizerById(Long eventOrganizerID);
}
