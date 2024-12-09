package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.EventOrganizerNotFoundException;
import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.infrastructure.event.dto.GetEventOrganizerResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventOrganizerRepository;
import com.miniproject.eventure.usecase.event.GetEventOrganizerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEventOrganizerUseCaseImpl implements GetEventOrganizerUseCase {
    @Autowired
    EventOrganizerRepository eventOrganizerRepository;

    @Override
    public GetEventOrganizerResponseDTO getEventOrganizerById(Long eventOrganizerID) {
        EventOrganizer eventOrganizer = eventOrganizerRepository.findById(eventOrganizerID)
                .orElseThrow(()-> new EventOrganizerNotFoundException(eventOrganizerID));

        return new GetEventOrganizerResponseDTO(eventOrganizer);
    }
}
