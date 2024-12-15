package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.usecase.user.GetUserTicketUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/{userId}/ticket")
public class UserTicketController {
    @Autowired
    GetUserTicketUseCase getUserTicketUseCase;

    @GetMapping
    public ResponseEntity<?> getAllUserTicket(@PathVariable Long userId){
        return ApiResponse.success(HttpStatus.OK.value(), "Get user ticket success", getUserTicketUseCase.getUserTicketById(userId));
    }
}
