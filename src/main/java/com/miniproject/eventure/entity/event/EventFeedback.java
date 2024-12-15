package com.miniproject.eventure.entity.event;

import com.miniproject.eventure.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "event_feedbacks")
public class EventFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_feedback_id_gen")
    @SequenceGenerator(name = "event_feedback_id_gen", sequenceName = "event_feedbacks_event_feedback_id_seq", allocationSize = 1)
    @Column(name = "event_feedback_id")
    private Long eventFeedbackId;

    @ManyToOne
    @JoinColumn(name = "event_ticket_id", nullable = false, foreignKey = @ForeignKey(name = "event_feedbacks_event_ticket_id_fkey"))
    private EventTicket eventTicket;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "event_feedbacks_user_id_fkey"))
    private User user;

    @Column(name = "feedback", length = 1000)
    private String feedback;

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

