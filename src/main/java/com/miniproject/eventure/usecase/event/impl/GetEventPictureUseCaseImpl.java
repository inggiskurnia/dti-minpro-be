package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.event.EventPicture;
import com.miniproject.eventure.infrastructure.event.repository.EventPictureRepository;
import com.miniproject.eventure.usecase.event.GetEventPictureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventPictureUseCaseImpl implements GetEventPictureUseCase {
    @Autowired
    EventPictureRepository eventPictureRepository;

    @Override
    public List<String> getAllEventPicture(Long eventId) {
        List<String> eventPictures = eventPictureRepository.findByEventEventId(eventId).stream()
                .map(EventPicture::getEventPictureUrl).toList();
        if (eventPictures.isEmpty()){
            throw new DataNotFoundException("Event pictures for event ID " + eventId + " not found !");
        }
        return eventPictures;
    }
}
