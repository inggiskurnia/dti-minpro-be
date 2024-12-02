package com.miniproject.eventure.entity.event;

import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Setter
@Getter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_gen")
    @SequenceGenerator(name = "events_id_gen", sequenceName = "events_event_id_seq", allocationSize = 1)
    @Column(name = "event_id")
    private Long eventId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_organizer"))
    private User organizerId;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Size(max = 2000)
    @Column(name = "description", nullable = false, columnDefinition = "TEXT", length = 2000)
    private String description;

    @NotNull
    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "event_category_id", foreignKey = @ForeignKey(name = "FK_event_category"))
    private EventCategory eventCategoryId;

    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "FK_city"))
    private City cityId;

    @Column(name = "location_detail", nullable = false, columnDefinition = "TEXT")
    private String locationDetail;

    @NotNull
    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @NotNull
    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @NotNull
    @Column(name = "started_at", nullable = false)
    private OffsetDateTime startedAt;

    @NotNull
    @Column(name = "ended_at", nullable = false)
    private OffsetDateTime endedAt;

    @NotNull
    @Min(0)
    @Column(name = "total_capacity", nullable = false)
    private Integer totalCapacity;

    @NotNull
    @Min(0)
    @Column(name = "total_available", nullable = false)
    private Integer totalAvailable;

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
