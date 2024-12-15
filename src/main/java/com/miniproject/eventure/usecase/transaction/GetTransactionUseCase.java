package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.infrastructure.transaction.dto.GetTransactionResponseDTO;

import java.util.List;

public interface GetTransactionUseCase {
    GetTransactionResponseDTO getTransaction(String invoiceNumber);
    List<GetTransactionResponseDTO> getTransactionByUserId(Long userId);
}
