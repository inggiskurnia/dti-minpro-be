package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.usecase.event.GetEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventUseCaseImpl implements GetEventUseCase {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(()-> new DataNotFoundException("Event not found !"));
    }

    @Override
    public PaginationInfo<GetPaginatedEventResponseDTO> getPaginatedEvent(PageRequest pageRequest) {
        Page<Event> eventsPage = eventRepository.findAll(pageRequest);
        List<GetPaginatedEventResponseDTO> eventsDTO = eventsPage.stream().map(GetPaginatedEventResponseDTO::new).toList();
        return new PaginationInfo<>(eventsPage, eventsDTO);
    }
}
