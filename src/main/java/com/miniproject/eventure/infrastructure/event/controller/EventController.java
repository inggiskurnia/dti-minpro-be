package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventFeedbackRequestDTO;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventRequestDTO;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventRequestDTO;
import com.miniproject.eventure.usecase.event.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    CreateEventFeedbackUseCase createEventFeedbackUseCase;

    @GetMapping
    public ResponseEntity<?> getAllEvent(){
        return ApiResponse.success(HttpStatus.OK.value(), "Get all event success", getEventUseCase.getAllEvent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Get event success", getEventUseCase.getEventById(id));
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody UpdateEventRequestDTO req){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Update event success", updateEventUseCase.updateEvent(id, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }

    @PostMapping("/review")
    public ResponseEntity<?> createEventReview(@RequestBody CreateEventReviewRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event review success",createEventReviewUseCase.createEventReview(req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }

    @PostMapping("/feedback")
    public ResponseEntity<?> createEventFeedback(@RequestBody CreateEventFeedbackRequestDTO req){
        try {
            return ApiResponse.success((HttpStatus.OK.value()), "Create event feedback success", createEventFeedbackUseCase.createEventFeedback(req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
}
