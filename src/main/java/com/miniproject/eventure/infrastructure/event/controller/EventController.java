package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventRequestDTO;
import com.miniproject.eventure.infrastructure.event.dto.UpdateEventRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventUseCase;
import com.miniproject.eventure.usecase.event.GetEventUseCase;
import com.miniproject.eventure.usecase.event.UpdateEventUseCase;
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

    @GetMapping
    public ResponseEntity<?> getAllEvent(){
        return ApiResponse.success(HttpStatus.OK.value(), "Get all event success", getEventUseCase.getAllEvent());
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
    public ResponseEntity<?> updateEvent(@PathVariable Long id, UpdateEventRequestDTO req){
        try {
            return ApiResponse.success(HttpStatus.OK.value(), "Update event success", updateEventUseCase.updateEvent(id, req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }
    }
}
