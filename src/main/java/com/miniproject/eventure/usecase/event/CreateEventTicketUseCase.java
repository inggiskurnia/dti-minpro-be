package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.ticket.EventTicket;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventTicketRequestDTO;

public interface CreateEventTicketUseCase {
    EventTicket createEventTicket(Long eventId, CreateEventTicketRequestDTO req);
}
