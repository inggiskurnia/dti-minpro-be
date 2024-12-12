package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.event.EventCategory;
import com.miniproject.eventure.infrastructure.event.dto.GetEventCategoryResponseDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventCategoryRepository;
import com.miniproject.eventure.usecase.event.GetEventCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventCategoryUseCaseImpl implements GetEventCategoryUseCase {
    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @Override
    public List<GetEventCategoryResponseDTO> getAllEventCategory() {
        return eventCategoryRepository.findAll().stream().map(GetEventCategoryResponseDTO::new).toList();
    }

    @Override
    public List<GetEventCategoryResponseDTO> searchEventCategory(String query) {
        List<EventCategory> foundEventCategories = eventCategoryRepository.findByNameContainingIgnoreCase(query);
        if (foundEventCategories.isEmpty()) {
            throw new DataNotFoundException("Event categories with query "+ query + " not found !");
        }
        return foundEventCategories.stream().map(GetEventCategoryResponseDTO::new).toList();
    }
}
