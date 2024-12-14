package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.GetEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.dto.SearchEventResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface GetEventUseCase {
    List<Event> getAllEvent();
    List<SearchEventResponseDTO> searchEventByName(String query);
    GetEventResponseDTO getEventById(Long eventId);
    PaginationInfo<GetPaginatedEventResponseDTO> getPaginatedEvent(PageRequest pageRequest, Long eventCategoryId, Long cityId);
}
