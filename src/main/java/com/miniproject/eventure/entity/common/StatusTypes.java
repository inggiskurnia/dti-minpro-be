package com.miniproject.eventure.entity.common;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "status_types")
public class StatusTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_types_id_gen")
    @SequenceGenerator(name = "status_types_id_gen", sequenceName = "status_types_status_type_id_seq", allocationSize = 1)
    @Column(name = "status_type_id")
    private Long statusTypeId;

    @NotNull
    @Column(name = "status_name")
    private String  statusName;

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
