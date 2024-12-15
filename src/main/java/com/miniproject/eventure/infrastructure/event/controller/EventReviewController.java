package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventReviewUseCase;
import com.miniproject.eventure.usecase.event.GetEventReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event/ticket/{eventTicketId}/review")
public class EventReviewController {

    @Autowired
    CreateEventReviewUseCase createEventReviewUseCase;

    @Autowired
    GetEventReviewUseCase getEventReviewUseCase;

    @GetMapping
    public ResponseEntity<?> getPaginatedEventReview(
            @PathVariable Long eventTicketId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event review success", getEventReviewUseCase.getPaginatedEventReview(eventTicketId, pageRequest));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> createEventReview(
            @PathVariable Long eventTicketId,
            @PathVariable Long userId,
            @RequestBody CreateEventReviewRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event review success", createEventReviewUseCase.createEventReview(eventTicketId, userId, req));
    }
}

