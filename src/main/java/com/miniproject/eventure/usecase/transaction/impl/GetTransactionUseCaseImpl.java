package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.common.exeptions.InvoiceNotFoundException;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.infrastructure.transaction.dto.GetTransactionResponseDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.usecase.transaction.GetTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTransactionUseCaseImpl implements GetTransactionUseCase {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public GetTransactionResponseDTO getTransaction(String invoiceNumber) {
        Transaction transaction = transactionRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(()-> new InvoiceNotFoundException(invoiceNumber));

        return new GetTransactionResponseDTO(transaction);
    }
}
