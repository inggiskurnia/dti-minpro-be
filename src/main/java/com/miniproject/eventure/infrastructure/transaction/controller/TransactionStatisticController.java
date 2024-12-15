package com.miniproject.eventure.infrastructure.transaction.controller;

import com.miniproject.eventure.infrastructure.transaction.dto.TransactionStatisticDTO;
import com.miniproject.eventure.usecase.transaction.TransactionStatisticUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions/statistics")
public class TransactionStatisticController {

    @Autowired
    private TransactionStatisticUseCase transactionStatisticUseCase;

    @GetMapping("/{eventId}")
    public TransactionStatisticDTO getTransactionStatistics(
            @PathVariable Long eventId,
            @RequestParam String range) {
        return transactionStatisticUseCase.getTransactionStatistic(eventId, range);
    }
}
