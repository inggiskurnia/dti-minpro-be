package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.*;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventCategory;
import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventCategoryRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventOrganizerRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.usecase.event.UpdateEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class UpdateEventUseCaseImpl implements UpdateEventUseCase {

    @Autowired
    EventOrganizerRepository eventOrganizerRepository;

    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public Event updateEvent(Long id, UpdateEventRequestDTO req) {

        Event event = eventRepository.findById(id)
                .orElseThrow(()-> new EventNotFoundException(id));

        if(req.getOrganizerId() != null){
            EventOrganizer organizer = eventOrganizerRepository.findById(req.getOrganizerId())
                    .orElseThrow(()-> new EventOrganizerNotFoundException(req.getOrganizerId()));
            event.setOrganizer(organizer);
        }
        if (req.getName() != null){
            event.setName(req.getName());
        }
        if (req.getDescription() != null){
            event.setDescription(req.getDescription());
        }
        if (req.getThumbnail() != null){
            event.setThumbnail(req.getThumbnail());
        }
        if (req.getEventCategoryId() != null) {
            EventCategory eventCategory = eventCategoryRepository.findById(req.getEventCategoryId())
                    .orElseThrow(() -> new EventCategoryNotFoundException(req.getEventCategoryId()));
            event.setEventCategory(eventCategory);
        }
        if (req.getCityId() != null){
            City city = cityRepository.findById(req.getCityId())
                    .orElseThrow(()-> new CityNotFoundException(req.getCityId()));
            event.setCity(city);
        }
        if (req.getLocationDetail() != null){
            event.setLocationDetail(req.getLocationDetail());
        }
        if (req.getLongitude() != null){
            event.setLongitude(req.getLongitude());
        }
        if (req.getLatitude() != null){
            event.setLatitude(req.getLatitude());
        }
        if (req.getStartedAt() != null){
            event.setStartedAt(req.getStartedAt());
        }
        if (req.getEndedAt() != null){
            event.setEndedAt(req.getEndedAt());
        }
        if (req.getTotalCapacity() != null){
            event.setTotalCapacity(req.getTotalCapacity());
        }
        if (req.getTotalAvailable() != null){
            event.setTotalAvailable(req.getTotalAvailable());
        }
        event.setUpdatedAt(OffsetDateTime.now());

        return eventRepository.save(event);
    }
}
