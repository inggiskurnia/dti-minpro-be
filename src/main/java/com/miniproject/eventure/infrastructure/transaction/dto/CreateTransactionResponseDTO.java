package com.miniproject.eventure.infrastructure.transaction.dto;

import com.miniproject.eventure.entity.transaction.Transaction;
import lombok.Data;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class CreateTransactionResponseDTO {

    private Long transactionId;
    private Long userId;
    private Long eventTicketId;
    private Integer totalTicket;
    private BigDecimal originalAmount;
    private BigDecimal voucherDeduction;
    private BigDecimal pointsDeduction;
    private BigDecimal totalAmount;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;

    public CreateTransactionResponseDTO(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        this.userId = transaction.getUser().getUserId();
        this.eventTicketId = transaction.getEventTicket().getEventTicketId();
        this.totalTicket = transaction.getTotalTicket();
        this.originalAmount = transaction.getOriginalAmount();
        this.voucherDeduction = transaction.getVoucherDeduction();
        this.pointsDeduction = transaction.getPointsDeduction();
        this.totalAmount = transaction.getTotalAmount();
        this.createdAt = transaction.getCreatedAt();
        this.updatedAt = transaction.getUpdatedAt();
        this.deletedAt = transaction.getDeletedAt();
    }
}
