package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventFeedbackRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventFeedbackUseCase;
import com.miniproject.eventure.usecase.event.GetEventFeedbackUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event/ticket/{eventTicketId}/feedback")
public class EventFeedbackController {

    @Autowired
    CreateEventFeedbackUseCase createEventFeedbackUseCase;

    @Autowired
    GetEventFeedbackUseCase getEventFeedbackUseCase;

    @GetMapping
    public ResponseEntity<?> getPaginatedEventFeedbackByEventId(
            @PathVariable Long eventTicketId,
            @RequestParam(required = false, defaultValue = "5") int limit,
            @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event feedback success", getEventFeedbackUseCase.getPaginatedEvent(eventTicketId, pageRequest));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> createEventFeedback(
            @PathVariable Long eventTicketId,
            @PathVariable Long userId,
            @RequestBody CreateEventFeedbackRequestDTO req) {
        return ApiResponse.success((HttpStatus.OK.value()), "Create event feedback success", createEventFeedbackUseCase.createEventFeedback(eventTicketId, userId, req));
    }
}

