package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.user.GetUserUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> getUserById(Long id) {
        var foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()){
            throw new DataNotFoundException("User not found !");
        }
        return foundUser;
    }

    @Override
    public Optional<User> getReferralCode(String referralCode) {
        var user = userRepository.findByReferralCode(referralCode);
        if (user.isEmpty()) {
            throw new DataNotFoundException("User with referral code not found!");
        }
        return user;
    }
}
