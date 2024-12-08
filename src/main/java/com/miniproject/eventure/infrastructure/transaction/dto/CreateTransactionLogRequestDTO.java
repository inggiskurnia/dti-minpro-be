package com.miniproject.eventure.infrastructure.transaction.dto;


import com.miniproject.eventure.entity.common.StatusTypes;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.entity.transaction.TransactionLog;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTransactionLogRequestDTO {

    @NotNull
    private Long transactionId;

    @NotNull
    private Long statusTypeId;

    public TransactionLog toEntity(Transaction transaction, StatusTypes statusType) {
        TransactionLog transactionLog = new TransactionLog();
        transactionLog.setTransaction(transaction);
        transactionLog.setStatusType(statusType);
        return transactionLog;
    }
}

