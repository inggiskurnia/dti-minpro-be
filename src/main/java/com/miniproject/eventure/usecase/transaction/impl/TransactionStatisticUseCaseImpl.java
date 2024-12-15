package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.infrastructure.transaction.dto.TransactionStatisticDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.usecase.transaction.TransactionStatisticUseCase;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class TransactionStatisticUseCaseImpl implements TransactionStatisticUseCase {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public TransactionStatisticDTO getTransactionStatistic(Long eventId, String range) {
        // Fetch the event by eventId
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        // Determine the start and end date based on the range (year, month, day)
        OffsetDateTime startDate;
        OffsetDateTime endDate = switch (range.toLowerCase()) {
            case "year" -> {
                startDate = OffsetDateTime.now().with(TemporalAdjusters.firstDayOfYear());
                yield OffsetDateTime.now().with(TemporalAdjusters.lastDayOfYear());
            }
            case "month" -> {
                startDate = OffsetDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
                yield OffsetDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
            }
            case "day" -> {
                startDate = OffsetDateTime.now().toLocalDate().atStartOfDay(OffsetDateTime.now().getOffset()).toOffsetDateTime();
                yield startDate.plusDays(1).minusSeconds(1);
            }
            default -> throw new IllegalArgumentException("Invalid range: " + range);
        };

        // Fetch transactions within the range
        List<Transaction> transactions = transactionRepository.findTransactionsByEventIdAndDateRange(eventId, startDate, endDate);

        // Calculate total transactions and total revenue
        int totalTransactions = transactions.size();
        BigDecimal totalRevenue = transactions.stream()
                .map(Transaction::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Calculate average revenue
        BigDecimal averageRevenue = totalTransactions > 0
                ? totalRevenue.divide(BigDecimal.valueOf(totalTransactions), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        // Return the DTO
        return new TransactionStatisticDTO(event, totalTransactions, totalRevenue, averageRevenue);
    }
}
