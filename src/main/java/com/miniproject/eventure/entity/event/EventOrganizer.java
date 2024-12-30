package com.miniproject.eventure.entity.event;

import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "event_organizers")
public class EventOrganizer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_organizers_id_gen")
    @SequenceGenerator(name = "event_organizers_id_gen", sequenceName = "event_organizers_event_organizer_id_seq", allocationSize = 1)
    @Column(name = "event_organizer_id")
    private Long eventOrganizerId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @NotNull
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column
    private String description;

    @Column(name = "profile_picture_link")
    private String profilePictureLink;

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
