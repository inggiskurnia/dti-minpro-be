package com.miniproject.eventure.entity.event;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "event_pictures")
public class EventPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_pictures_id_gen")
    @SequenceGenerator(name = "event_pictures_id_gen", sequenceName = "event_pictures_id_seq", allocationSize = 1)
    @Column(name = "event_picture_id")
    private Long eventPictureId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @NotNull
    @Column(name = "link_picture", nullable = false, columnDefinition = "TEXT")
    private String linkPicture;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}

