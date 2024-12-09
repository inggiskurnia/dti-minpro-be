package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
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

import java.util.Optional;

@Service
public class CreateEventFeedbackUseCaseImpl implements CreateEventFeedbackUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventFeedbackRepository eventFeedbackRepository;

    @Autowired
    EventRepository eventRepository;

    @Override
    public EventFeedback createEventFeedback(Long eventId, Long userId, CreateEventFeedbackRequestDTO req) {
        Optional<EventFeedback> foundEventFeedback = eventFeedbackRepository.findByEventEventIdAndUserUserId(eventId, userId);
        if (foundEventFeedback.isPresent()){
            throw new DuplicateRequestDataException("User already gave feedback for this event !");
        }

        EventFeedback newEventFeedback = new EventFeedback();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new EventNotFoundException(eventId));

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));

        newEventFeedback.setEvent(event);
        newEventFeedback.setUser(user);
        newEventFeedback.setFeedback(req.getFeedback());

        return eventFeedbackRepository.save(newEventFeedback);
    }
}
