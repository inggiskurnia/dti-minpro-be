package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class UpdateUserRequestDTO {
    @Size(min = 1, max = 100)
    private String fullName;

    @Email
    @Size(max = 100)
    private String email;

    @Size(min = 8, max = 255)
    private String password;

    private Long cityId;

    private LocalDateTime birthdate;

    private String profilePicture;

    public User toEntity() {
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthdate(birthdate);
        user.setProfilePicture(profilePicture);
        user.setUpdatedAt(OffsetDateTime.now());

        return user;
    }
}
