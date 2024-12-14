package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.Role;
import com.miniproject.eventure.entity.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


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

    @NotNull
    private OffsetDateTime birthdate;

    public User toEntity(){
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> roles = new HashSet<>();
        user.setRoles(roles);
        user.setBirthdate(birthdate);
        return user;
    }

}
