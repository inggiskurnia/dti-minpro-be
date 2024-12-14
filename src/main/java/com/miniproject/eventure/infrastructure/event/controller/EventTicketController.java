package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventTicketRequestDTO;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventTicketRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventTicketUseCase;
import com.miniproject.eventure.usecase.event.GetEventTicketUseCase;
import com.miniproject.eventure.usecase.event.UpdateEventTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event/{eventId}/ticket")
public class EventTicketController {

    @Autowired
    CreateEventTicketUseCase createEventTicketUseCase;

    @Autowired
    GetEventTicketUseCase getEventTicketUseCase;

    @Autowired
    UpdateEventTicketUseCase updateEventTicketUseCase;

    @PostMapping
    public ResponseEntity<?> createEventTicket(
            @PathVariable Long eventId,
            @RequestBody CreateEventTicketRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create new ticket success", createEventTicketUseCase.createEventTicket(eventId, req));
    }

    @GetMapping
    public ResponseEntity<?> getEventTicketByEventId(@PathVariable Long eventId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get ticket success", getEventTicketUseCase.getEventTicketByEventId(eventId));
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateEventTicket(
            @PathVariable Long eventId,
            @PathVariable Long ticketId,
            @RequestBody UpdateEventTicketRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Update event ticket success !", updateEventTicketUseCase.updateEventTicket(eventId, ticketId, req));
    }
}

