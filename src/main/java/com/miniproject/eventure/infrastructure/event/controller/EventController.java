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
    private CreateEventUseCase createEventUseCase;

    @Autowired
    private GetEventUseCase getEventUseCase;

    @Autowired
    private UpdateEventUseCase updateEventUseCase;

    @Autowired
    private CreateEventReviewUseCase createEventReviewUseCase;

    @Autowired
    private GetEventReviewUseCase getEventReviewUseCase;

    @Autowired
    private CreateEventFeedbackUseCase createEventFeedbackUseCase;

    @Autowired
    private GetEventFeedbackUseCase getEventFeedbackUseCase;

    @Autowired
    private CreateEventPictureUseCase createEventPictureUseCase;

    @Autowired
    private GetEventPictureUseCase getEventPictureUseCase;

    @Autowired
    private CreateEventOrganizerUseCase createEventOrganizerUseCase;

    @Autowired
    private GetEventOrganizerUseCase getEventOrganizerUseCase;

    @Autowired
    private CreateEventTicketUseCase createEventTicketUseCase;

    @Autowired
    private GetEventTicketUseCase getEventTicketUseCase;

    @Autowired
    private UpdateEventTicketUseCase updateEventTicketUseCase;

    @GetMapping
    public ResponseEntity<?> getEvent(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get event page success", getEventUseCase.getPaginatedEvent(pageRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEvent() {
        return ApiResponse.success(HttpStatus.OK.value(), "Get all event success", getEventUseCase.getAllEvent());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get event success", getEventUseCase.getEventById(eventId));
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

    @GetMapping("/{eventId}/review")
    public ResponseEntity<?> getPaginatedEventReview(
            @PathVariable Long eventId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event review success", getEventReviewUseCase.getPaginatedEventReview(eventId, pageRequest));
    }

    @PostMapping("/{eventId}/review")
    public ResponseEntity<?> createEventReview(
            @PathVariable Long eventId,
            @RequestBody CreateEventReviewRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event review success", createEventReviewUseCase.createEventReview(eventId, req));
    }

    @GetMapping("/{eventId}/feedback")
    public ResponseEntity<?> getPaginatedEventFeedbackByEventId(
            @PathVariable Long eventId,
            @RequestParam(required = false, defaultValue = "5") int limit,
            @RequestParam(required = false, defaultValue = "0") int page) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event feedback success", getEventFeedbackUseCase.getPaginatedEvent(eventId, pageRequest));
    }

    @PostMapping("/{eventId}/feedback/user/{userId}")
    public ResponseEntity<?> createEventFeedback(
            @PathVariable Long eventId,
            @PathVariable Long userId,
            @RequestBody CreateEventFeedbackRequestDTO req) {
        return ApiResponse.success((HttpStatus.OK.value()), "Create event feedback success", createEventFeedbackUseCase.createEventFeedback(eventId, userId, req));
    }

    @PostMapping("/{eventId}/picture")
    public ResponseEntity<?> createEventPicture(
            @PathVariable Long eventId,
            @RequestBody BulkCreateEventPictureRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event pictures success", createEventPictureUseCase.bulkCreateEventPicture(eventId, req));
    }

    @GetMapping("{eventId}/picture")
    public ResponseEntity<?> getAllEventPicture(@PathVariable Long eventId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get all event pictures success", getEventPictureUseCase.getAllEventPicture(eventId));
    }

    @PostMapping("/organizer")
    public ResponseEntity<?> createEventOrganizer(@RequestBody CreateEventOrganizerRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create event organizer success", createEventOrganizerUseCase.createEventOrganizer(req));
    }

    @GetMapping("/organizer/{eventOrganizerId}")
    public ResponseEntity<?> getEventOrganizerById(@PathVariable Long eventOrganizerId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get event organizer by ID success", getEventOrganizerUseCase.getEventOrganizerById(eventOrganizerId));
    }

    @PostMapping("/{eventId}/ticket")
    public ResponseEntity<?> createEventTicket(
            @PathVariable Long eventId,
            @RequestBody CreateEventTicketRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create new ticket success", createEventTicketUseCase.createEventTicket(eventId, req));
    }

    @GetMapping("/{eventId}/ticket")
    public ResponseEntity<?> getEventTicketByEventId(@PathVariable Long eventId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get ticket success", getEventTicketUseCase.getEventTicketByEventId(eventId));
    }

    @PutMapping("/{eventId}/ticket/{ticketId}")
    public ResponseEntity<?> updateEventTicket(
            @PathVariable Long eventId,
            @PathVariable Long ticketId,
            @RequestBody UpdateEventTicketRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Update event ticket success !", updateEventTicketUseCase.updateEventTicket(eventId, ticketId, req));
    }
}
