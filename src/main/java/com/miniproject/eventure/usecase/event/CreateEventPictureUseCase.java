package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventPicture;
import com.miniproject.eventure.infrastructure.event.dto.BulkCreateEventPictureRequestDTO;

import java.util.List;

public interface CreateEventPictureUseCase {
    List<EventPicture> bulkCreateEventPicture(Long eventId, BulkCreateEventPictureRequestDTO req);
}
