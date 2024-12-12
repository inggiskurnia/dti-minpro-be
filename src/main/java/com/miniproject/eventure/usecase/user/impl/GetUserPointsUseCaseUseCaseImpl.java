package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
import com.miniproject.eventure.usecase.user.GetUserPointsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class GetUserPointsUseCaseUseCaseImpl implements GetUserPointsUseCase {
    @Autowired
    UserPointsRepository userPointsRepository;

    @Override
    public Double getTotalUserPoint(Long userId) {
        Double balance = userPointsRepository.findTotalCurrentBalance(userId, OffsetDateTime.now());
        return (balance != null) ? balance : 0.0;
    }
}
