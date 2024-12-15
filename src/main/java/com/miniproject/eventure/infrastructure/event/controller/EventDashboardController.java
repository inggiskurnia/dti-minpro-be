package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.usecase.event.EventDashboardUseCase;
import com.miniproject.eventure.infrastructure.event.dto.EventDashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
public class EventDashboardController {

    @Autowired
    private EventDashboardUseCase eventDashboardUseCase;

    @GetMapping("/organizer/{organizerId}")
    public List<EventDashboardDTO> getDashboard(@PathVariable Long organizerId) {
        return eventDashboardUseCase.getEventDashboard(organizerId);
    }
}
