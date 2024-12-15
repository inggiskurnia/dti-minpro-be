package com.miniproject.eventure.entity.event;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "event_tickets")
public class EventTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_tickets_id_gen")
    @SequenceGenerator(name = "event_tickets_id_gen", sequenceName = "event_tickets_event_ticket_id_seq", allocationSize = 1)
    @Column(name = "event_ticket_id")
    private Long eventTicketId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false, foreignKey = @ForeignKey(name = "FK_event"))
    private Event event;

    @NotNull
    @Column(name = "ticket_name")
    private String ticketName;

    @NotNull
    @DecimalMin("0.0")
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Min(0)
    @Column(name = "total_capacity", nullable = false)
    private Integer totalCapacity;

    @NotNull
    @Min(0)
    @Column(name = "total_available", nullable = false)
    private Integer totalAvailable;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "started_at", nullable = false)
    private OffsetDateTime startedAt;

    @NotNull
    @Column(name = "ended_at", nullable = false)
    private OffsetDateTime endedAt;

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

