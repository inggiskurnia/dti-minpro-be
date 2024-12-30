package com.miniproject.eventure.entity.voucher;

import com.miniproject.eventure.entity.event.Event;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name = "vouchers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vouchers_id_gen")
    @SequenceGenerator(name = "vouchers_id_gen", sequenceName = "vouchers_voucher_id_seq", allocationSize = 1)
    @Column(name = "voucher_id")
    private Long voucherId;

    @Column(name = "code", unique = true)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Min(0)
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Min(0)
    @Column(name = "total_capacity")
    private Integer totalCapacity;

    @Min(0)
    @Column(name = "total_available")
    private Integer totalAvailable;

    @Column(name = "validity_period")
    private String validityPeriod;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "voucher_type_id", nullable = false)
    private VoucherType voucherType;

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

