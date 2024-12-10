package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventReviewRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.event.CreateEventReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateEventReviewUseCaseImpl implements CreateEventReviewUseCase {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventReviewRepository eventReviewRepository;

    @Override
    public EventReview createEventReview(Long eventId, CreateEventReviewRequestDTO req) {
        Optional<EventReview> foundEventReview = eventReviewRepository.findByEventEventIdAndUserUserId(eventId, req.getUserId());
        if (foundEventReview.isPresent()){
            throw new DuplicateRequestDataException("User already gave review for this event !");
        }

        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new EventNotFoundException(eventId));

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException(req.getUserId()));

        EventReview newEventReview = new EventReview();
        newEventReview.setEvent(event);
        newEventReview.setUser(user);
        newEventReview.setRating(req.getRating());
        newEventReview.setDescription(req.getDescription());

        return eventReviewRepository.save(newEventReview);
    }
}
