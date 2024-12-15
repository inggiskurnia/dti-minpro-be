package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionResponseDTO;
import jakarta.transaction.Transactional;

public interface CreateTransactionUseCase {
    @Transactional
    CreateTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req);
}
