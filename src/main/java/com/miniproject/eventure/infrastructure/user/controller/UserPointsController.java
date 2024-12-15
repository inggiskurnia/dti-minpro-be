package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserPointsRequestDTO;
import com.miniproject.eventure.usecase.user.CreateUserPointsUseCase;
import com.miniproject.eventure.usecase.user.GetUserPointsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/{userId}/points")
public class UserPointsController {

    @Autowired
    CreateUserPointsUseCase createUserPointsUseCase;

    @Autowired
    GetUserPointsUseCase getUserPointsUseCase;

    @PostMapping
    public ResponseEntity<?> createUserPoints(@PathVariable Long userId, @RequestBody CreateUserPointsRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create user points success", createUserPointsUseCase.createUserPoints(userId, req));
    }

    @GetMapping("/total")
    public ResponseEntity<?> getTotalPointsAvailable(@PathVariable Long userId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get total available points success", getUserPointsUseCase.getTotalUserPoint(userId));
    }
}
