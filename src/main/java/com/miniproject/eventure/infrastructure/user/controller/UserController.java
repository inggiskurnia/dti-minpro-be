package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserPointsRequestDTO;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserVoucherRequestDTO;
import com.miniproject.eventure.infrastructure.user.dto.UpdateUserRequestDTO;
import com.miniproject.eventure.usecase.user.*;
import com.miniproject.eventure.usecase.voucher.GetVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    CreateUserUseCase createUserUseCase;

    @Autowired
    GetUserUseCase getUserUseCase;

    @Autowired
    UpdateUserUseCase updateUserUseCase;

    @Autowired
    CreateUserVoucherUseCase createUserVoucherUseCase;

    @Autowired
    CreateUserPointsUseCase createUserPointsUseCase;

    @Autowired
    GetUserVoucherUseCase getUserVoucherUseCase;

    @Autowired
    GetUserPointsUseCase getUserPointsUseCase;

    @GetMapping
    public ResponseEntity<?> getUser() {
        return ApiResponse.success(HttpStatus.OK.value(), "Get all user success", getUserUseCase.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable final Long id) {
        return ApiResponse.success(HttpStatus.OK.value(), "User found !", getUserUseCase.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create user success", createUserUseCase.createUser(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Long id, @RequestBody UpdateUserRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Update user success !", updateUserUseCase.updateUser(id, req));
    }

    @PostMapping("/voucher")
    public ResponseEntity<?> createUsesVoucher(@RequestBody CreateUserVoucherRequestDTO req){
        return ApiResponse.success(HttpStatus.OK.value(), "Create user voucher success", createUserVoucherUseCase.createUserVoucher(req));
    }

    @GetMapping("/{userId}/voucher")
    public ResponseEntity<?> getUserVoucher(@PathVariable Long userId){
        return ApiResponse.success(HttpStatus.OK.value(), "Get user voucher success", getUserVoucherUseCase.getUserVoucher(userId));
    }

    @PostMapping("/{userId}/points")
    public ResponseEntity<?> createUserPoints(@PathVariable Long userId, @RequestBody CreateUserPointsRequestDTO req){
        return ApiResponse.success(HttpStatus.OK.value(), "Create user points success", createUserPointsUseCase.createUserPoints(userId,req));
    }

    @GetMapping("/{userId}/points/total")
    public ResponseEntity<?> getTotalPointsAvailable(@PathVariable Long userId){
        return ApiResponse.success(HttpStatus.OK.value(), "Get total available points success", getUserPointsUseCase.getTotalUserPoint(userId));
    }

}
