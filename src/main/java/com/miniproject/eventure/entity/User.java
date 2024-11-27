package com.miniproject.eventure.entity;

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
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Size(min = 8, max = 255)
    @Column(nullable = false, length = 255)
    private String password;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String role;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City city;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}


