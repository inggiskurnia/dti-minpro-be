package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.Event;

import java.util.List;


public interface GetEventUseCase {
    List<Event> getAllEvent();
    Event getEventById(Long id);
}
