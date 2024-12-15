package com.miniproject.eventure.infrastructure.transaction.dto;

import com.miniproject.eventure.entity.event.Event;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionStatisticDTO {

    private Long eventId;
    private String name;
    private Integer totalTransactions;
    private BigDecimal totalRevenue;
    private BigDecimal averageRevenue;

    public TransactionStatisticDTO(
            Event event,
            Integer totalTransactions,
            BigDecimal totalRevenue,
            BigDecimal averageRevenue
    ) {
        this.eventId = event.getEventId();
        this.name = event.getName();
        this.totalTransactions = totalTransactions;
        this.totalRevenue = totalRevenue;
        this.averageRevenue = averageRevenue;
    }
}
