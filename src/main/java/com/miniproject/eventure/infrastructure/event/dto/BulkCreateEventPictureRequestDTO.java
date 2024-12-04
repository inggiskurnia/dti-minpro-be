package com.miniproject.eventure.infrastructure.event.dto;

import lombok.Data;

import java.util.List;

@Data
public class BulkCreateEventPictureRequestDTO {

    private List<CreateEventPictureRequestDTO> eventPictureUrls;
}
