package com.miniproject.eventure.infrastructure.event.dto;

import com.miniproject.eventure.entity.event.EventCategory;
import lombok.Data;

@Data
public class GetEventCategoryResponseDTO {
    private Long eventCategoryId;
    private String eventCategory;

    public GetEventCategoryResponseDTO(EventCategory eventCategory){
        this.eventCategoryId = eventCategory.getEventCategoryId();
        this.eventCategory = eventCategory.getName();
    }
}
