package com.miniproject.eventure.infrastructure.transaction.dto;

import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.entity.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long eventTicketId;

    @NotNull
    private Integer totalTicket;

    @NotNull
    private BigDecimal originalAmount;

    private Long userVoucherId;

    private Long voucherId;

    private BigDecimal voucherDeduction;

    private BigDecimal pointsDeduction;

    @NotNull
    private BigDecimal totalAmount;

    public Transaction toEntity(User user, String invoiceNumber, EventTicket eventTicket) {
        Transaction transaction = new Transaction();
        transaction.setInvoiceNumber(invoiceNumber);
        transaction.setUser(user);
        transaction.setEventTicket(eventTicket);
        transaction.setTotalTicket(this.totalTicket);
        transaction.setOriginalAmount(this.originalAmount);
        transaction.setVoucherDeduction(this.voucherDeduction);
        transaction.setPointsDeduction(this.pointsDeduction);
        transaction.setTotalAmount(this.totalAmount);
        return transaction;
    }
}
