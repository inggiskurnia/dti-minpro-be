package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface GetEventUseCase {
    List<Event> getAllEvent();
    Event getEventById(Long eventId);
    PaginationInfo<GetPaginatedEventResponseDTO> getPaginatedEvent(PageRequest pageRequest);
}
