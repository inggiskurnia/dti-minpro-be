package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.EventReview;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventReviewResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventReviewRepository;
import com.miniproject.eventure.usecase.event.GetEventReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetEventReviewUseCaseImpl implements GetEventReviewUseCase {

    @Autowired
    EventReviewRepository eventReviewRepository;

    @Override
    public List<EventReview> getAllEventReview() {
        return eventReviewRepository.findAll();
    }

    @Override
    public Optional<EventReview> getAllEventReviewById(Long eventReviewId) {
        return eventReviewRepository.findById(eventReviewId);
    }

    @Override
    public PaginationInfo<GetPaginatedEventReviewResponseDTO> getPaginatedEventReview(Long evenTicketId, PageRequest pageRequest) {
        Page<EventReview> eventReviews = eventReviewRepository.findByEventTicketEventTicketId(evenTicketId, pageRequest);
        if (eventReviews.isEmpty()){
            throw new DataNotFoundException("Event review with event ID " + evenTicketId + " not found !");
        }

        List<GetPaginatedEventReviewResponseDTO> eventReviewsDTO = eventReviews.stream().map(GetPaginatedEventReviewResponseDTO::new).toList();
        return new PaginationInfo<>(eventReviews, eventReviewsDTO);
    }
}
