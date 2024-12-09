package com.miniproject.eventure.usecase.user.impl;

import com.miniproject.eventure.common.exeptions.TransactionNotFoundException;
import com.miniproject.eventure.common.exeptions.UserNotFoundException;
import com.miniproject.eventure.common.utils.ExpiryDate;
import com.miniproject.eventure.entity.transaction.Transaction;
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
    public UserPoints createUserPoints(CreateUserPointsRequestDTO req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException(req.getUserId()));

        UserPoints userPoints = req.toEntity();
        userPoints.setUser(user);

        // Deduction from transaction checkout
        if (req.getTransactionId() != null){
            Transaction transaction = transactionRepository.findById(req.getTransactionId())
                    .orElseThrow(()-> new TransactionNotFoundException(req.getTransactionId()));
            userPoints.setTransaction(transaction);
        }
        // Redeem from referral code
        else if (req.getValidityPeriod() != null){
            OffsetDateTime expiryAt = expiryDate.calculateExpiryDate(req.getValidityPeriod());
            userPoints.setExpiredAt(expiryAt);
        }

        return userPointsRepository.save(userPoints);
    }
}
