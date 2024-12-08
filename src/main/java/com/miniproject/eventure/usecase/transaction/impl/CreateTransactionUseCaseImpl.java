package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionResponseDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.transaction.CreateTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public CreateTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req) {
        return null;
    }
}
