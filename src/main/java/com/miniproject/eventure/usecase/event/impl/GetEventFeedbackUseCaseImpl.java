package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.EventFeedbackNotFoundException;
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
        return eventFeedbackRepository.findById(eventFeedbackId)
                .orElseThrow(EventFeedbackNotFoundException::new);
    }

    @Override
    public PaginationInfo<GetPaginatedEventFeedbackResponseDTO> getPaginatedEvent(Long eventTicketId, PageRequest pageRequest) {
        Page<EventFeedback> eventFeedbacksPage = eventFeedbackRepository.findByEventTicketEventTicketId(eventTicketId,pageRequest);
        if (eventFeedbacksPage.isEmpty()){
            throw new EventFeedbackNotFoundException();
        }
        List<GetPaginatedEventFeedbackResponseDTO> eventFeedbacksDTO = eventFeedbacksPage.stream().map(GetPaginatedEventFeedbackResponseDTO::new).toList();

        return new PaginationInfo<>(eventFeedbacksPage, eventFeedbacksDTO);
    }
}
