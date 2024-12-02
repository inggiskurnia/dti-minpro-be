package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.infrastructure.user.dto.UpdateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.user.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public User updateUser(Long id, UpdateUserRequestDTO req) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User ID is not found!"));

        if (req.getEmail() != null && !foundUser.getEmail().equals(req.getEmail())) {
            if (userRepository.existsByEmail(req.getEmail())) {
                throw new DuplicateRequestDataException("Email is already taken");
            }
            foundUser.setEmail(req.getEmail());
        }

        if (req.getFullName() != null) {
            foundUser.setFullName(req.getFullName());
        }
        if (req.getEmail() != null) {
            foundUser.setEmail(req.getEmail());
        }
        if (req.getPassword() != null) {
            foundUser.setPassword(req.getPassword());
        }
        if (req.getBirthdate() != null) {
            foundUser.setBirthdate(req.getBirthdate());
        }
        if (req.getProfilePicture() != null) {
            foundUser.setProfilePicture(req.getProfilePicture());
        }
        if (req.getCityId() != null) {
            City city = cityRepository.findById(req.getCityId())
                    .orElseThrow(() -> new DataNotFoundException("City ID is not found!"));
            foundUser.setCity(city);
        }
        foundUser.setUpdatedAt(OffsetDateTime.now());

        return userRepository.save(foundUser);
    }


}
