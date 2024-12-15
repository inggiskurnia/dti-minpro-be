package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EventTicketNotFoundException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventReviewRepository;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.event.CreateEventReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateEventReviewUseCaseImpl implements CreateEventReviewUseCase {
    @Autowired
    EventTicketRepository eventTicketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventReviewRepository eventReviewRepository;

    @Override
    public EventReview createEventReview(Long eventTicketId, Long userId, CreateEventReviewRequestDTO req) {
        Optional<EventReview> foundEventReview = eventReviewRepository.findByEventTicketEventTicketIdAndUserUserId(eventTicketId, userId);
        if (foundEventReview.isPresent()){
            throw new DuplicateRequestDataException("User already gave review for this event ticket !");
        }

        EventTicket eventTicket = eventTicketRepository.findById(eventTicketId)
                .orElseThrow(()-> new EventTicketNotFoundException(eventTicketId));

        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));

        EventReview newEventReview = new EventReview();
        newEventReview.setEventTicket(eventTicket);
        newEventReview.setUser(user);
        newEventReview.setRating(req.getRating());
        newEventReview.setDescription(req.getDescription());

        return eventReviewRepository.save(newEventReview);
    }
}
