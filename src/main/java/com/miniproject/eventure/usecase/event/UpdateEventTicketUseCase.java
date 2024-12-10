package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventTicketRequestDTO;

public interface UpdateEventTicketUseCase {
    EventTicket updateEventTicket(Long eventId, Long ticketId, UpdateEventTicketRequestDTO req);
}
