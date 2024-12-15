package com.miniproject.eventure.common.utils;

import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class InvoiceService {

    @Autowired
    private TransactionRepository transactionRepository;

    public synchronized String generateInvoiceNumber() {
        YearMonth currentYearMonth = YearMonth.now();
        String currentYearMonthStr = currentYearMonth.toString().replace("-", "");

        int nextSequence = 1;
        String newInvoiceNumber;

        while (true) {
            newInvoiceNumber = String.format("INV-%s-%04d", currentYearMonthStr, nextSequence);
            if (!transactionRepository.existsByInvoiceNumber(newInvoiceNumber)) {
                break;
            }
            nextSequence++;
        }

        return newInvoiceNumber;
    }
}
