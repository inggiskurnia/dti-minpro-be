package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.infrastructure.event.dto.GetEventTicketResponseDTO;

import java.util.List;

public interface GetEventTicketUseCase {
    List<GetEventTicketResponseDTO> getEventTicketByEventId(Long eventId);
}
