package com.miniproject.eventure.common.utils;

import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private TransactionRepository transactionRepository;

    public synchronized String generateInvoiceNumber() {
        YearMonth currentYearMonth = YearMonth.now();
        String currentYearMonthStr = currentYearMonth.toString().replace("-", "");

        Optional<String> lastInvoiceNumber = transactionRepository.findTopByInvoiceNumberStartingWithOrderByInvoiceNumberDesc(currentYearMonthStr);
        int nextSequence = lastInvoiceNumber.map(this::extractSequenceNumber).orElse(0) + 1;

        return String.format("INV-%s-%04d", currentYearMonthStr, nextSequence);
    }

    private int extractSequenceNumber(String invoiceNumber) {
        return Integer.parseInt(invoiceNumber.substring(invoiceNumber.lastIndexOf("-") + 1));
    }
}

