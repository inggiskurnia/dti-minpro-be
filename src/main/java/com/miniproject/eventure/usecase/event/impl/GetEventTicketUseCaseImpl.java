package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.EventTicketNotFoundException;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.infrastructure.event.dto.GetEventTicketResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.usecase.event.GetEventTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventTicketUseCaseImpl implements GetEventTicketUseCase {

    @Autowired
    EventTicketRepository eventTicketRepository;

    @Override
    public List<GetEventTicketResponseDTO> getEventTicketByEventId(Long eventId) {

        List<EventTicket> eventTickets = eventTicketRepository.findByEventEventId(eventId);
        if (eventTickets.isEmpty()){
            throw new EventTicketNotFoundException(eventId);
        }

        return eventTickets.stream().map(GetEventTicketResponseDTO::new).toList();
    }
}
