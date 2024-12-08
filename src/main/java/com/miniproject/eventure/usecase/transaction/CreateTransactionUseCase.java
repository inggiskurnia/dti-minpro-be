package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionResponseDTO;

public interface CreateTransactionUseCase {
    CreateTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req);
}
