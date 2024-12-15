package com.miniproject.eventure.usecase.transaction.impl;

import com.miniproject.eventure.common.exeptions.*;
import com.miniproject.eventure.common.utils.InvoiceService;
import com.miniproject.eventure.common.utils.UserPointsService;
import com.miniproject.eventure.entity.event.EventTicket;
import com.miniproject.eventure.entity.transaction.Transaction;
import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.entity.user.UserTicket;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.event.repository.EventTicketRepository;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionRequestDTO;
import com.miniproject.eventure.infrastructure.transaction.repository.TransactionRepository;
import com.miniproject.eventure.infrastructure.transaction.dto.CreateTransactionResponseDTO;
import com.miniproject.eventure.infrastructure.user.dto.UserPointsResponseDTO;
import com.miniproject.eventure.infrastructure.user.repository.UserPointsRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserTicketRepository;
import com.miniproject.eventure.infrastructure.user.repository.UserVoucherRepository;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import com.miniproject.eventure.usecase.transaction.CreateTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    EventTicketRepository eventTicketRepository;

    @Autowired
    UserPointsRepository userPointsRepository;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    UserVoucherRepository userVoucherRepository;

    @Autowired
    UserTicketRepository userTicketRepository;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    VoucherRepository voucherRepository;


    @Override
    public CreateTransactionResponseDTO createTransaction(CreateTransactionRequestDTO req) {

        // create new transaction
        String invoiceNumber = invoiceService.generateInvoiceNumber();
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new UserNotFoundException(req.getUserId()));
        EventTicket eventTicket = eventTicketRepository.findById(req.getEventTicketId())
                .orElseThrow(() -> new EventTicketNotFoundException(req.getEventTicketId()));
        Transaction newTransaction = req.toEntity(user, invoiceNumber, eventTicket);
        transactionRepository.save(newTransaction);

        // Step 2: Update user points
        UserPointsResponseDTO userPointsResponseDTO = null;
        if (req.getPointsDeduction() != null) {
            userPointsResponseDTO = userPointsService.deductUserPoints(req.getUserId(), req.getPointsDeduction());
        }

        // Step 3: Update user vouchers
        if (req.getUserVoucherId() != null) {
            UserVoucher userVoucher = userVoucherRepository.findById(req.getUserVoucherId())
                    .orElseThrow(() -> new DataNotFoundException("User voucher not found !"));
            userVoucher.setUsedAt(OffsetDateTime.now());
            userVoucherRepository.save(userVoucher);

        }

        // Step 4: Update vouchers;
        if (req.getVoucherId() != null) {
            Voucher voucher = voucherRepository.findById(req.getVoucherId())
                    .orElseThrow(VoucherNotFoundException::new);
            voucher.setTotalAvailable(voucher.getTotalAvailable() - 1);
        }

        // Step 5: Update event tickets
        Integer eventTicketTotalAvailable = eventTicket.getTotalAvailable() - req.getTotalTicket();
        eventTicket.setTotalAvailable(eventTicketTotalAvailable);
        eventTicketRepository.save(eventTicket);

        // Step 6: Create new user tickets
        UserTicket userTicket = new UserTicket();
        userTicket.setUser(user);
        userTicket.setEventTicket(eventTicket);
        userTicket.setTotalTicket(req.getTotalTicket());
        userTicketRepository.save(userTicket);

        return new CreateTransactionResponseDTO(newTransaction, userPointsResponseDTO, eventTicketTotalAvailable);
    }
}
