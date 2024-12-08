package com.miniproject.eventure.infrastructure.voucher.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.voucher.dto.CreateVoucherRequestDTO;
import com.miniproject.eventure.usecase.voucher.CreateVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/voucher")
public class VoucherController {

    @Autowired
    CreateVoucherUseCase createVoucherUseCase;

    @PostMapping
    public ResponseEntity<?> createVoucher(@RequestBody CreateVoucherRequestDTO req){
        return ApiResponse.success(HttpStatus.OK.value(), "Create voucher success", createVoucherUseCase.createVoucher(req));
    }
}
