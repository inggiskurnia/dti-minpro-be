package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
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

    @GetMapping
    public ResponseEntity<?> getEvent(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page)
    {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get event page success", getEventUseCase.getPaginatedEvent(pageRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEvent(){
        return ApiResponse.success(HttpStatus.OK.value(), "Get all event success", getEventUseCase.getAllEvent());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> getEventById(@PathVariable Long eventId){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Get event success", getEventUseCase.getEventById(eventId));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody CreateEventRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event success !", createEventUseCase.createEvent(req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<?> updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventRequestDTO req){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Update event success", updateEventUseCase.updateEvent(eventId, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @GetMapping("/{eventId}/review")
    public ResponseEntity<?> getPaginatedEventReview(
            @PathVariable Long eventId,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int page)
    {
        PageRequest pageRequest = PageRequest.of(page, limit);
        return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event review success", getEventReviewUseCase.getPaginatedEventReview(eventId, pageRequest));
    }

    @PostMapping("/{eventId}/review")
    public ResponseEntity<?> createEventReview(@PathVariable Long eventId, @RequestBody CreateEventReviewRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event review success",createEventReviewUseCase.createEventReview(eventId, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }

    @GetMapping("/{eventId}/feedback")
    public ResponseEntity<?> getPaginatedEventFeedbackByEventId(
            @PathVariable Long eventId,
            @RequestParam(required = false, defaultValue = "5") int limit,
            @RequestParam(required = false, defaultValue = "0") int page
    ){
        try {
            PageRequest pageRequest = PageRequest.of(page, limit);
            return ApiResponse.success(HttpStatus.OK.value(), "Get paginated event feedback success", getEventFeedbackUseCase.getPaginatedEvent(eventId, pageRequest));
        } catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PostMapping("/{eventId}/feedback/user/{userId}")
    public ResponseEntity<?> createEventFeedback(@PathVariable Long eventId, @PathVariable Long userId, @RequestBody CreateEventFeedbackRequestDTO req){
        try {
            return ApiResponse.success((HttpStatus.OK.value()), "Create event feedback success", createEventFeedbackUseCase.createEventFeedback(eventId, userId, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }

    @PostMapping("/{eventId}/picture")
    public ResponseEntity<?> createEventPicture(@PathVariable Long eventId, @RequestBody BulkCreateEventPictureRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event pictures success", createEventPictureUseCase.bulkCreateEventPicture(eventId, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @GetMapping("{eventId}/picture")
    public ResponseEntity<?> getAllEventPicture(@PathVariable Long eventId){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Get all event pictures success", getEventPictureUseCase.getAllEventPicture(eventId));
        } catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PostMapping("/organizer")
    public ResponseEntity<?> createEventOrganizer(@RequestBody CreateEventOrganizerRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event organizer success", createEventOrganizerUseCase.createEventOrganizer(req));
        } catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }

    @GetMapping("/organizer/{eventOrganizerId}")
    public ResponseEntity<?> getEventOrganizerById(@PathVariable Long eventOrganizerId){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Get event organizer by ID success", getEventOrganizerUseCase.getEventOrganizerById(eventOrganizerId));
        } catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PostMapping("/{eventId}/ticket")
    public ResponseEntity<?> createEventTicket(@PathVariable Long eventId, @RequestBody CreateEventTicketRequestDTO req){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Create new ticket success", createEventTicketUseCase.createEventTicket(eventId, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @GetMapping("/{eventId}/ticket")
    public ResponseEntity<?> getEventTicketByEventId(@PathVariable Long eventId){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Get ticket success", getEventTicketUseCase.getEventTicketByEventId(eventId));
        } catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
}
