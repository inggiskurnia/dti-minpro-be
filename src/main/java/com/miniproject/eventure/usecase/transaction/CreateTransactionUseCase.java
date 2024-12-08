package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.dto.GetTransactionResponseDTO;

public interface CreateTransactionUseCase {
    GetTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req);
}
