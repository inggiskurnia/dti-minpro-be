package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.common.utils.PaginationInfo;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.infrastructure.event.dto.GetEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.dto.GetPaginatedEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.dto.SearchEventResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.usecase.event.GetEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventUseCaseImpl implements GetEventUseCase {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public List<SearchEventResponseDTO> searchEventByName(String query) {
        List<Event> foundEvents = eventRepository.findByNameContainingIgnoreCase(query);
        if (foundEvents.isEmpty()){
            throw new DataNotFoundException("Event not found !");
        }
        return foundEvents.stream().map(SearchEventResponseDTO::new).toList();
    }

    @Override
    public GetEventResponseDTO getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new EventNotFoundException(eventId));
        return new GetEventResponseDTO(event);
    }

    @Override
    public PaginationInfo<GetPaginatedEventResponseDTO> getPaginatedEvent(PageRequest pageRequest, Long eventCategoryId, Long cityId) {
        Specification<Event> spec = Specification.where(null);

        if (eventCategoryId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("eventCategory").get("eventCategoryId"), eventCategoryId));
        }

        if (cityId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("city").get("cityId"), cityId));
        }

        Page<Event> eventsPage = eventRepository.findAll(spec, pageRequest);
        List<GetPaginatedEventResponseDTO> eventsDTO = eventsPage.stream().map(GetPaginatedEventResponseDTO::new).toList();
        return new PaginationInfo<>(eventsPage, eventsDTO);
    }
}
