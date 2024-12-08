package com.miniproject.eventure.entity.transaction;

import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_id_gen")
    @SequenceGenerator(name = "transactions_id_gen", sequenceName = "transactions_transaction_id_seq", allocationSize = 1)
    @Column(name = "transaction_id")
    private Long transactionId;

    @NotNull
    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_tickets_id", nullable = false)
    private EventTicket eventTicket;

    @NotNull
    @Column(name = "total_ticket", nullable = false)
    private Integer totalTicket;

    @NotNull
    @Column(name = "original_amount", nullable = false)
    private BigDecimal originalAmount;

    @Column(name = "voucher_deduction")
    private BigDecimal voucherDeduction;

    @Column(name = "points_deduction")
    private BigDecimal pointsDeduction;

    @NotNull
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
        updatedAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }

    @PreRemove
    protected void onRemove() {
        deletedAt = OffsetDateTime.now();
    }
}