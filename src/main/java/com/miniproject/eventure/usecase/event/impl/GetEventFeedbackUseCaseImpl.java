package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.EventFeedback;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventFeedbackResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventFeedbackRepository;
import com.miniproject.eventure.usecase.event.GetEventFeedbackUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventFeedbackUseCaseImpl implements GetEventFeedbackUseCase {
    @Autowired
    EventFeedbackRepository eventFeedbackRepository;

    @Override
    public List<EventFeedback> getAllEventFeedback() {
        return eventFeedbackRepository.findAll();
    }

    @Override
    public EventFeedback getEventFeedbackById(Long eventFeedbackId) {
        return eventFeedbackRepository.findById(eventFeedbackId).orElseThrow(()-> new DataNotFoundException("Event feedback with Id " + eventFeedbackId + " not found !"));
    }

    @Override
    public PaginationInfo<GetPaginatedEventFeedbackResponseDTO> getPaginatedEvent(Long eventId, PageRequest pageRequest) {
        Page<EventFeedback> eventFeedbacksPage = eventFeedbackRepository.findByEventEventId(eventId,pageRequest);
        if (eventFeedbacksPage.isEmpty()){
            throw new DataNotFoundException("Feedback for event Id" + eventId + " not found !");
        }
        List<GetPaginatedEventFeedbackResponseDTO> eventFeedbacksDTO = eventFeedbacksPage.stream().map(GetPaginatedEventFeedbackResponseDTO::new).toList();

        return new PaginationInfo<>(eventFeedbacksPage, eventFeedbacksDTO);
    }
}
