package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventOrganizerRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventOrganizerUseCase;
import com.miniproject.eventure.usecase.event.GetEventOrganizerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event-organizer")
public class EventOrganizerController {

    @Autowired
    CreateEventOrganizerUseCase createEventOrganizerUseCase;

    @Autowired
    GetEventOrganizerUseCase getEventOrganizerUseCase;

    @PostMapping
    public ResponseEntity<?> createEventOrganizer(@RequestBody CreateEventOrganizerRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event organizer success", createEventOrganizerUseCase.createEventOrganizer(req));
    }

    @GetMapping("/{eventOrganizerId}")
    public ResponseEntity<?> getEventOrganizerById(@PathVariable Long eventOrganizerId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get event organizer by ID success", getEventOrganizerUseCase.getEventOrganizerById(eventOrganizerId));
    }
}
