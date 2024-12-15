package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.*;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventFeedbackRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventFeedbackRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
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
    EventTicketRepository eventTicketRepository;

    @Override
    public EventFeedback createEventFeedback(Long eventTicketId, Long userId, CreateEventFeedbackRequestDTO req) {
        Optional<EventFeedback> foundEventFeedback = eventFeedbackRepository.findByEventTicketEventTicketIdAndUserUserId(eventTicketId, userId);
        if (foundEventFeedback.isPresent()){
            throw new DuplicateRequestDataException("User already gave feedback for this event !");
        }

        EventFeedback newEventFeedback = new EventFeedback();

        EventTicket eventTicket = eventTicketRepository.findById(eventTicketId)
                .orElseThrow(()-> new EventTicketNotFoundException(eventTicketId));

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));

        newEventFeedback.setEventTicket(eventTicket);
        newEventFeedback.setUser(user);
        newEventFeedback.setFeedback(req.getFeedback());

        return eventFeedbackRepository.save(newEventFeedback);
    }
}
