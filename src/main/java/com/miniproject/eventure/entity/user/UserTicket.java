package com.miniproject.eventure.entity.user;

import com.miniproject.eventure.entity.event.EventTicket;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "user_tickets")
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tickets_id_gen")
    @SequenceGenerator(name = "user_tickets_id_gen", sequenceName = "user_tickets_user_ticket_id_seq", allocationSize = 1)
    @Column(name = "user_ticket_id")
    private Long userTicketId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "event_ticket_id", nullable = false)
    private EventTicket eventTicket;

    @NotNull
    @Column(name = "total_ticket", nullable = false)
    private Integer totalTicket;

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
