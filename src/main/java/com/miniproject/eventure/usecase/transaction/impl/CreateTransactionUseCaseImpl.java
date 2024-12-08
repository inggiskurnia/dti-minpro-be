package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.common.exeptions.*;
import com.miniproject.eventure.common.utils.InvoiceService;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.dto.GetTransactionResponseDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.usecase.transaction.CreateTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    EventTicketRepository eventTicketRepository;

    @Autowired
    InvoiceService invoiceService;

    @Override
    public GetTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req) {
        String invoiceNumber = invoiceService.generateInvoiceNumber();

        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException(req.getUserId()));

        EventTicket eventTicket = eventTicketRepository.findById(req.getEventTicketId())
                .orElseThrow(()-> new EventTicketNotFoundException(req.getEventTicketId()));

        Transaction newTransaction = req.toEntity(user, invoiceNumber, eventTicket);

        transactionRepository.save(newTransaction);

        return new GetTransactionResponseDTO(newTransaction);
    }
}
