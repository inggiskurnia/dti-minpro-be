package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventPicture;

import java.util.List;

public interface GetEventPictureUseCase {
    List<String> getAllEventPicture(Long eventId);
}
