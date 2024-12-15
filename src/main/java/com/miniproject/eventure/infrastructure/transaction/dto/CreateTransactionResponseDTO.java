package com.miniproject.eventure.infrastructure.transaction.dto;

import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.infrastructure.user.dto.UserPointsResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class CreateTransactionResponseDTO {
    private Long transactionId;
    private String invoiceNumber;
    private Long userId;
    private BigDecimal userTotalPoints;
    private BigDecimal userUsedPoints;
    private Long userTicketId;
    private Long eventTicketId;
    private String eventTicketName;
    private Integer totalTicket;
    private Integer totalAvailableTicket;
    private OffsetDateTime createdAt;

    public CreateTransactionResponseDTO(Transaction transaction, UserPointsResponseDTO userPointsResponseDTO, Integer totalAvailableTicket) {
        this.transactionId = transaction.getTransactionId();
        this.invoiceNumber = transaction.getInvoiceNumber();
        this.userId = transaction.getUser().getUserId();
        this.userTotalPoints = userPointsResponseDTO.getTotalPoints();
        this.userUsedPoints = userPointsResponseDTO.getTotalUsedPoints();
        this.eventTicketId = transaction.getEventTicket().getEventTicketId();
        this.eventTicketName = transaction.getEventTicket().getTicketName();
        this.totalTicket = transaction.getTotalTicket();
        this.totalAvailableTicket = totalAvailableTicket;
        this.createdAt = transaction.getCreatedAt();
    }
}
