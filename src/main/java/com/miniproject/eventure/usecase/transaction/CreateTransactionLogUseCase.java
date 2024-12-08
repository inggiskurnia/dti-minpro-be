package com.miniproject.eventure.usecase.transaction;

import com.miniproject.eventure.entity.transaction.TransactionLog;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionLogRequestDTO;

public interface CreateTransactionLogUseCase {
    TransactionLog createTransactionLog(CreateTransactionLogRequestDTO req);
}
