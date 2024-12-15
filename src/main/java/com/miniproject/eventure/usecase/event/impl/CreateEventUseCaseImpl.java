package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.CityNotFoundException;
import com.miniproject.eventure.common.exeptions.EventCategoryNotFoundException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventCategory;
import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventCategoryRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventOrganizerRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.usecase.event.CreateEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEventUseCaseImpl implements CreateEventUseCase {

    @Autowired
    EventOrganizerRepository eventOrganizerRepository;

    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event createEvent(CreateEventRequestDTO req) {
        Event newEvent = req.toEntity();

        EventOrganizer eventOrganizer = eventOrganizerRepository.findById(req.getOrganizerId())
                .orElseThrow(() -> new UserNotFoundException(req.getOrganizerId()));
        newEvent.setOrganizer(eventOrganizer);

        EventCategory eventCategory = eventCategoryRepository.findById(req.getEventCategoryId())
                .orElseThrow(() -> new EventCategoryNotFoundException(req.getEventCategoryId()));
        newEvent.setEventCategory(eventCategory);

        City city = cityRepository.findById(req.getCityId())
                .orElseThrow(() -> new CityNotFoundException(req.getCityId()));
        newEvent.setCity(city);

        return eventRepository.save(newEvent);
    }
}
