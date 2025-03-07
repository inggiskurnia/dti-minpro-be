package com.miniproject.eventure.usecase.event.impl;

import com.miniproject.eventure.common.exeptions.CityNotFoundException;
import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.entity.event.EventOrganizer;
import com.miniproject.eventure.entity.geography.City;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.dto.CreateEventOrganizerRequestDTO;
import com.miniproject.eventure.infrastructure.event.repository.EventOrganizerRepository;
import com.miniproject.eventure.infrastructure.geography.repository.CityRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.event.CreateEventOrganizerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateEventOrganizerUseCaseImpl implements CreateEventOrganizerUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    EventOrganizerRepository eventOrganizerRepository;

    @Override
    public EventOrganizer createEventOrganizer(CreateEventOrganizerRequestDTO req) {
        Optional<EventOrganizer> foundEventOrganizer = eventOrganizerRepository.findByUserUserId(req.getUserId());
        if (foundEventOrganizer.isPresent()){
            throw new DuplicateRequestDataException("User with Id " + req.getUserId() + " already register as event organizer");
        }

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException(req.getUserId()));

        City city = cityRepository.findById(req.getCityId())
                .orElseThrow(()-> new CityNotFoundException(req.getCityId()));

        return eventOrganizerRepository.save(req.toEntity(user, city));
    }
}
