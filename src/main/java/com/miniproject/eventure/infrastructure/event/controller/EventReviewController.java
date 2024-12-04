package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventReviewRequestDTO;
import com.miniproject.eventure.usecase.event.CreateEventReviewUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/event/review")
public class EventReviewController {

    @Autowired
    CreateEventReviewUseCase createEventReviewUseCase;

    @PostMapping
    public ResponseEntity<?> createEventReview(@RequestBody CreateEventReviewRequestDTO req){
        try{
            return ApiResponse.success(HttpStatus.OK.value(), "Create event review success",createEventReviewUseCase.createEventReview(req));
        }catch (DataNotFoundException e){
            return ApiResponse.failed(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }catch (DuplicateRequestDataException e){
            return ApiResponse.failed(HttpStatus.CONFLICT.value(), e.getMessage());
        }
    }
}
