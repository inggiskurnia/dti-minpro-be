package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventFeedbackRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventFeedbackRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.event.CreateEventFeedbackUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEventFeedbackUseCaseImpl implements CreateEventFeedbackUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventFeedbackRepository eventFeedbackRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventFeedback createEventFeedback(CreateEventFeedbackRequestDTO req) {
        EventFeedback newEventFeedback = new EventFeedback();

        Event event = eventRepository.findById(req.getEventId())
                .orElseThrow(()-> new DataNotFoundException("Event with Id "+ req.getEventId() + " not found !"));

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new DataNotFoundException("User with Id" + req.getUserId() + "not found"));

        newEventFeedback.setEvent(event);
        newEventFeedback.setUser(user);
        newEventFeedback.setFeedback(req.getFeedback());

        return eventFeedbackRepository.save(newEventFeedback);
    }
}
