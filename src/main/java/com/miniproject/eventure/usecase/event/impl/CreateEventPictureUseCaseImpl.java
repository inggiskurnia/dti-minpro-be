package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventPicture;
import com.miniproject.eventure.infrastructure.event.dto.BulkCreateEventPictureRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventPictureRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.usecase.event.CreateEventPictureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateEventPictureUseCaseImpl implements CreateEventPictureUseCase {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventPictureRepository eventPictureRepository;

    @Override
    public List<EventPicture> bulkCreateEventPicture(Long eventId, BulkCreateEventPictureRequestDTO req) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new DataNotFoundException("Event with ID " + eventId + "not found !"));

        List<EventPicture> eventPictures = req.getEventPictureUrls().stream() .map(dto -> dto.toEntity(event)).toList();

        return eventPictureRepository.saveAll(eventPictures);
    }
}
