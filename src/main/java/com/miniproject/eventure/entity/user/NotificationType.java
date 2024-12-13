package com.miniproject.eventure.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "notification_types")
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_types_id_gen")
    @SequenceGenerator(name = "notification_types_id_gen", sequenceName = "notification_types_notification_type_id_seq", allocationSize = 1)
    @Column(name = "notification_type_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_name", nullable = false, unique = true, length = 255)
    private String typeName;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
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
