package com.miniproject.eventure.entity.transaction;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transaction_logs")
@Data
@NoArgsConstructor
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_logs_id_gen")
    @SequenceGenerator(name = "transaction_logs_id_gen", sequenceName = "transaction_logs_transaction_log_id_seq", allocationSize = 1)
    @Column(name = "transaction_log_id")
    private Long transactionLogId;

    @ManyToOne
    @JoinColumn(name = "transactions_id", nullable = false)
    private Transaction transaction;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
    }
}
