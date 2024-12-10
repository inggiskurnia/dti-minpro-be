package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.GetTransactionResponseDTO;

public interface GetTransactionUseCase {
    GetTransactionResponseDTO getTransaction(String invoiceNumber);
}
