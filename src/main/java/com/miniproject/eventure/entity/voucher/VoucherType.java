package com.miniproject.eventure.entity.voucher;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "voucher_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoucherType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_types_id_gen")
    @SequenceGenerator(name = "voucher_types_id_gen", sequenceName = "voucher_types_voucher_type_id_seq", allocationSize = 1)
    @Column(name = "voucher_type_id")
    private Long voucherTypeId;

    @NotNull
    @Column(name = "status_name")
    private String name;

    @Column(name = "description")
    private String description;

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
