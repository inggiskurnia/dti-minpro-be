package com.miniproject.eventure.infrastructure.voucher.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.voucher.dto.CreateVoucherRequestDTO;
import com.miniproject.eventure.usecase.voucher.CreateVoucherUseCase;
import com.miniproject.eventure.usecase.voucher.GetVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/voucher")
public class VoucherController {

    @Autowired
    CreateVoucherUseCase createVoucherUseCase;

    @Autowired
    GetVoucherUseCase getVoucherUseCase;

    @GetMapping
    public  ResponseEntity<?> getAllVoucher(){
        return  ApiResponse.success(HttpStatus.OK.value(), "Get all voucher success", getVoucherUseCase.getAllVoucher());
    }

    @GetMapping("/{voucherId}")
    public ResponseEntity<?> getVoucherByVoucherId(@PathVariable Long voucherId) {
        return ApiResponse.success(HttpStatus.OK.value(), "Get event voucher success", getVoucherUseCase.getVoucherById(voucherId));
    }

    @PostMapping
    public ResponseEntity<?> createVoucher(@RequestBody CreateVoucherRequestDTO req){
        return ApiResponse.success(HttpStatus.OK.value(), "Create voucher success", createVoucherUseCase.createVoucher(req));
    }
}
