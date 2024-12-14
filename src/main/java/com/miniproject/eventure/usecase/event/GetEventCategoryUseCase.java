package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.infrastructure.event.dto.GetEventCategoryResponseDTO;

import java.util.List;

public interface GetEventCategoryUseCase {
    List<GetEventCategoryResponseDTO> getAllEventCategory();
    List<GetEventCategoryResponseDTO> searchEventCategory(String query);
}
