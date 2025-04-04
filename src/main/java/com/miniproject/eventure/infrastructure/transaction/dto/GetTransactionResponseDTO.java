package com.miniproject.eventure.infrastructure.transaction.dto;

import com.miniproject.eventure.entity.transaction.Transaction;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class GetTransactionResponseDTO {

    private Long transactionId;
    private String invoiceNumber;
    private Long userId;
    private BigDecimal userUsedPoints;
    private Long eventTicketId;
    private String eventTicketName;
    private Integer totalTicket;
    private Integer totalAvailableTicket;
    private BigDecimal originalAmount;
    private BigDecimal voucherDeduction;
    private BigDecimal pointsDeduction;
    private BigDecimal totalAmount;
    private OffsetDateTime createdAt;

    public GetTransactionResponseDTO(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.invoiceNumber = transaction.getInvoiceNumber();
        this.userId = transaction.getUser().getUserId();
        this.eventTicketId = transaction.getEventTicket().getEventTicketId();
        this.eventTicketName = transaction.getEventTicket().getTicketName();
        this.totalTicket = transaction.getTotalTicket();
        this.originalAmount = transaction.getOriginalAmount();
        this.voucherDeduction = transaction.getVoucherDeduction();
        this.pointsDeduction = transaction.getPointsDeduction();
        this.totalAmount = transaction.getTotalAmount();
        this.createdAt = transaction.getCreatedAt();
    }
}
