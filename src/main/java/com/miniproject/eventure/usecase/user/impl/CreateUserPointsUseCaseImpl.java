package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.common.utils.ExpiryDate;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.entity.user.UserPoints;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserPointsRequestDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.user.CreateUserPointsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CreateUserPointsUseCaseImpl implements CreateUserPointsUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserPointsRepository userPointsRepository;

    @Autowired
    ExpiryDate expiryDate;

    @Override
    public UserPoints createUserPoints(Long userId, CreateUserPointsRequestDTO req) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));

        OffsetDateTime expiryAt = expiryDate.calculateExpiryDate(req.getValidityPeriod());

        return userPointsRepository.save(req.toEntity(user, expiryAt));
    }
}
