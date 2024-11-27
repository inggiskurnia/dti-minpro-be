package com.miniproject.eventure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_id_gen")
    @SequenceGenerator(name = "events_id_gen", sequenceName = "events_id_seq", allocationSize = 1)
    @Column(name = "event_id")
    private Long eventId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_organizer"))
    private User organizer;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_category_id", foreignKey = @ForeignKey(name = "FK_event_category"))
    private EventCategory eventCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "FK_city"))
    private City city;

    @Column(columnDefinition = "TEXT")
    private String locationDetail;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime date;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer totalCapacity;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer totalAvailable;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
