package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateUserRequestDTO {

    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(min = 8, max = 255)
    private String password;

    @NotNull
    private boolean isOrganizer;

    public User toEntity(){
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsOrganizer(isOrganizer);

        return user;
    }

}
