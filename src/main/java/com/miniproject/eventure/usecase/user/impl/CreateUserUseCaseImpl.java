package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.user.CreateUserUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequestDTO req) {
        Optional<User> foundUser = userRepository.findByEmail(req.getEmail());
        if(foundUser.isPresent()){
            throw new DuplicateRequestDataException("Email already exist");
        }

        User newUser = req.toEntity();
        return userRepository.save(newUser);
    }
}
