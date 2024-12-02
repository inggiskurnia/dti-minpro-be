package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.utils.ReferralCodeGenerator;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
    private Long cityId;

    @NotNull
    private LocalDateTime birthdate;

    @NotNull
    @Size(max = 50)
    private String isOrganizer;

    @Autowired
    ReferralCodeGenerator referralCodeGenerator;

    @Autowired
    CityRepository cityRepository;

    public User toEntity(){
        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(password);

        City city = cityRepository.findById(cityId)
                .orElseThrow(()-> new DataNotFoundException("City ID not found!"));
        user.setCity(city);

        user.setBirthdate(birthdate);
        user.setIsOrganizer(isOrganizer);
        user.setReferralCode(referralCodeGenerator.generateReferralCode(fullName, birthdate));

        return user;
    }

}
