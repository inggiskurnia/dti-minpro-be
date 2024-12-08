package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventTicketRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.usecase.event.UpdateEventTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEventTicketUseCaseImpl implements UpdateEventTicketUseCase {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventTicketRepository eventTicketRepository;

    @Override
    public EventTicket updateEventTicket(Long eventId, Long ticketId, UpdateEventTicketRequestDTO req) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new DataNotFoundException("Event with ID " + eventId + " not found !"));

        EventTicket eventTicket = eventTicketRepository.findById(ticketId)
                .orElseThrow((()-> new DataNotFoundException("Ticket with ID " + ticketId + " not found !")));

        if (req.getTicketName() != null){
            eventTicket.setTicketName(req.getTicketName());
        }
        if (req.getPrice() != null){
            eventTicket.setPrice(req.getPrice());
        }
        if (req.getTotalCapacity() != null){
            eventTicket.setTotalCapacity(req.getTotalCapacity());
        }
        if (req.getTotalAvailable() != null){
            eventTicket.setTotalAvailable(req.getTotalAvailable());
        }
        if (req.getDescription() != null){
            eventTicket.setDescription(req.getDescription());
        }
        if (req.getStartedAt() != null){
            eventTicket.setStartedAt(req.getStartedAt());
        }
        if (req.getEndedAt() != null){
            eventTicket.setEndedAt(req.getEndedAt());
        }

        return eventTicketRepository.save(eventTicket);
    }
}
