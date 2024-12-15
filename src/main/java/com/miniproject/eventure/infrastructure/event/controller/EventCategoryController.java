package com.miniproject.eventure.infrastructure.event.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.usecase.event.GetEventCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/event/category")
public class EventCategoryController {

    @Autowired
    GetEventCategoryUseCase getEventCategoryUseCase;

    @GetMapping()
    public ResponseEntity<?> getEventCategory(@RequestParam(required = false) String query){
        if (query != null){
            return ApiResponse.success(HttpStatus.OK.value(), "Get event category success",getEventCategoryUseCase.searchEventCategory(query));
        }else{
            return ApiResponse.success(HttpStatus.OK.value(), "Get event category success", getEventCategoryUseCase.getAllEventCategory());
        }
    }
}
