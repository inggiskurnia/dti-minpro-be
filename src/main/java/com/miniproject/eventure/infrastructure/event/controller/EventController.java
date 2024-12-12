package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.*;
import com.miniproject.eventure.usecase.event.*;
import com.miniproject.eventure.usecase.voucher.GetVoucherUseCase;
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

    @Autowired
    CreateEventReviewUseCase createEventReviewUseCase;

    @Autowired
    GetEventReviewUseCase getEventReviewUseCase;

    @Autowired
    CreateEventFeedbackUseCase createEventFeedbackUseCase;

    @Autowired
    GetEventFeedbackUseCase getEventFeedbackUseCase;

    @Autowired
    CreateEventPictureUseCase createEventPictureUseCase;

    @Autowired
    GetEventPictureUseCase getEventPictureUseCase;

    @Autowired
    CreateEventOrganizerUseCase createEventOrganizerUseCase;

    @Autowired
    GetEventOrganizerUseCase getEventOrganizerUseCase;

    @Autowired
    CreateEventTicketUseCase createEventTicketUseCase;

    @Autowired
    GetEventTicketUseCase getEventTicketUseCase;

    @Autowired
    UpdateEventTicketUseCase updateEventTicketUseCase;

    @Autowired
    GetVoucherUseCase getVoucherUseCase;

    @Autowired
    GetEventCategoryUseCase getEventCategoryUseCase;

    @GetMapping
    public ResponseEntity<?> getEvent(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false) Long eventCategoryId,
            @RequestParam(required = false) Long cityId) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get event page success", getEventUseCase.getPaginatedEvent(pageRequest, eventCategoryId, cityId));
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

    @GetMapping("/event/category")
    public ResponseEntity<?> getEventCategory(@RequestParam(required = false) String query){
//        if (!query.isEmpty()){
//            return ApiResponse.success(HttpStatus.OK.value(), "Get event category success",getEventCategoryUseCase.searchEventCategory(query));
//        }else{
            return ApiResponse.success(HttpStatus.OK.value(), "Get event category success", getEventCategoryUseCase.getAllEventCategory());
//        }
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

    @GetMapping("/{eventId}/voucher")
    public ResponseEntity<?> getVoucherByEvent(@PathVariable Long eventId){
        return ApiResponse.success(HttpStatus.OK.value(), "Get event voucher success", getVoucherUseCase.getEventVoucher(eventId));
    }
}

