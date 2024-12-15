package com.miniproject.eventure.entity.user;

import com.miniproject.eventure.entity.transaction.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "redeemed_points")
public class RedeemedPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "redeemed_points_id_gen")
    @SequenceGenerator(name = "redeemed_points_id_gen", sequenceName = "redeemed_points_redeemed_point_id_seq", allocationSize = 1)
    @Column(name = "redeemed_point_id")
    private Long redeemedPointId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_point_id", nullable = false)
    private UserPoints userPoints;

    @NotNull
    @Column(name = "redeemed_amount", nullable = false)
    private BigDecimal redeemedAmount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
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
