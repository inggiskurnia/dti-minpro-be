package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.user.GetUserUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
