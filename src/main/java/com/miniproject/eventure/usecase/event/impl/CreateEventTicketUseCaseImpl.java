package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventTicketRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.usecase.event.CreateEventTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEventTicketUseCaseImpl implements CreateEventTicketUseCase {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventTicketRepository eventTicketRepository;

    @Override
    public EventTicket createEventTicket(Long eventId, CreateEventTicketRequestDTO req) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new EventNotFoundException(eventId));

        EventTicket newEventTicket = req.toEntity(event);
        return eventTicketRepository.save(newEventTicket);
    }
}
