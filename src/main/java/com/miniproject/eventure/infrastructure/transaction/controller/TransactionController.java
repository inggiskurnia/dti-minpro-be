package com.miniproject.eventure.infrastructure.transaction.controller;

import com.miniproject.eventure.common.responses.ApiResponse;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.usecase.transaction.CreateTransactionUseCase;
import com.miniproject.eventure.usecase.transaction.GetTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    CreateTransactionUseCase createTransactionUseCase;

    @Autowired
    GetTransactionUseCase getTransactionUseCase;

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequestDTO req){
        return ApiResponse.success(HttpStatus.OK.value(), "Create new transaction success", createTransactionUseCase.createTransaction(req));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getTransactionByUserId(@PathVariable Long userId){
        return ApiResponse.success(HttpStatus.OK.value(), "Get transaction success", getTransactionUseCase.getTransactionByUserId(userId));
    }

    @GetMapping("/{invoiceNumber}")
    public ResponseEntity<?> getTransaction(@PathVariable String invoiceNumber){
        return ApiResponse.success(HttpStatus.OK.value(), "Get transaction success", getTransactionUseCase.getTransaction(invoiceNumber));
    }
}
