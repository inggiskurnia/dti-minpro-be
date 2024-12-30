package com.miniproject.eventure.infrastructure.user.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserVoucherRequestDTO;
import com.miniproject.eventure.usecase.user.CreateUserVoucherUseCase;
import com.miniproject.eventure.usecase.user.GetUserVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/voucher")
public class UserVoucherController {

    @Autowired
    CreateUserVoucherUseCase createUserVoucherUseCase;

    @Autowired
    GetUserVoucherUseCase getUserVoucherUseCase;

    @PostMapping
    public ResponseEntity<?> createUserVoucher(@RequestBody CreateUserVoucherRequestDTO req) {
        return ApiResponse.success(HttpStatus.OK.value(), "Create user voucher success", createUserVoucherUseCase.createUserVoucher(req));
    }

    @GetMapping
    public ResponseEntity<?> getUserVoucher(@PathVariable Long userId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get user voucher success", getUserVoucherUseCase.getUserVoucher(userId));
    }
}
