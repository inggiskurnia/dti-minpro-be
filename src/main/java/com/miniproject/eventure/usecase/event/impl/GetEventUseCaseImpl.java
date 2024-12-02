package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.usecase.event.GetEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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
}
