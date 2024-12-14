package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.*;
import com.miniproject.eventure.usecase.event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
public class EventController {

    @Autowired
    CreateEventUseCase createEventUseCase;

    @Autowired
    GetEventUseCase getEventUseCase;

    @Autowired
    UpdateEventUseCase updateEventUseCase;

    @GetMapping
    public ResponseEntity<?> getEvent(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false) Long eventCategoryId,
            @RequestParam(required = false) Long cityId) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get event page success", getEventUseCase.getPaginatedEvent(pageRequest, eventCategoryId, cityId));
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<?> searchEventByName(@RequestParam String query){
        return ApiResponse.success(HttpStatus.OK.value(), "Get event success", getEventUseCase.searchEventByName(query));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId) {
        if (eventId != null){
            return ApiResponse.success(HttpStatus.OK.value(), "Get event success", getEventUseCase.getEventById(eventId));
        } else {
            return ApiResponse.success(HttpStatus.OK.value(), "Get all event success", getEventUseCase.getAllEvent());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event success !", createEventUseCase.createEvent(req));
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(
            @PathVariable Long eventId,
            @RequestBody UpdateEventRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Update event success", updateEventUseCase.updateEvent(eventId, req));
    }
}

