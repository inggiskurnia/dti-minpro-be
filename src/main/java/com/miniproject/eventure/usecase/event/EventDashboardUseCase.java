package com.miniproject.eventure.usecase.event;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.infrastructure.event.dto.EventDashboardDTO;

import java.util.List;

public interface EventDashboardUseCase {
    List<EventDashboardDTO> getEventDashboard(Long organizerId);
}
