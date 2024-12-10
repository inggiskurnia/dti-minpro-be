package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.common.exeptions.StatusTypeNotFoundException;
import com.miniproject.eventure.common.exeptions.TransactionNotFoundException;
import com.miniproject.eventure.entity.common.StatusTypes;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.entity.transaction.TransactionLog;
import com.miniproject.eventure.infrastructure.common.repository.StatusTypeRepository;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionLogRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionLogRepository;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.usecase.transaction.CreateTransactionLogUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionLogUseCaseImpl implements CreateTransactionLogUseCase {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionLogRepository transactionLogRepository;

    @Autowired
    StatusTypeRepository statusTypeRepository;


    @Override
    public TransactionLog createTransactionLog(CreateTransactionLogRequestDTO req) {
        Transaction transaction = transactionRepository.findById(req.getTransactionId())
                .orElseThrow(()-> new TransactionNotFoundException(req.getTransactionId()));

        StatusTypes statusTypes = statusTypeRepository.findById(req.getStatusTypeId())
                .orElseThrow(()-> new StatusTypeNotFoundException(req.getStatusTypeId()));
        TransactionLog transactionLog = req.toEntity(transaction, statusTypes);
        return transactionLogRepository.save(transactionLog);
    }
}
