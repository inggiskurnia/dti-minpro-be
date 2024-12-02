package com.miniproject.eventure.entity.user;

import com.miniproject.eventure.entity.geography.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Size(min = 8, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City city;

    @NotNull
    @Column(name = "birthdate", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime birthdate;

    @NotNull
    @Size(max = 50)
    @Column(name = "is_organizer",nullable = false, length = 50)
    private String isOrganizer;

    @Column(name = "referral_code")
    private String referralCode;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}


