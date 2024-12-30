package com.miniproject.eventure.usecase.voucher.impl;

import com.miniproject.eventure.common.exeptions.DuplicateRequestDataException;
import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.common.exeptions.VoucherTypeNotFoundException;
import com.miniproject.eventure.common.utils.VoucherService;
import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.entity.voucher.VoucherType;
import com.miniproject.eventure.infrastructure.event.repository.EventRepository;
import com.miniproject.eventure.infrastructure.voucher.dto.CreateVoucherRequestDTO;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherTypeRepository;
import com.miniproject.eventure.usecase.voucher.CreateVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateVoucherUseCaseImpl implements CreateVoucherUseCase {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    VoucherTypeRepository voucherTypeRepository;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    VoucherService voucherService;

    @Override
    public Voucher createVoucher(CreateVoucherRequestDTO req) {
        Optional<Voucher> voucher = voucherRepository.findByName(req.getName());
        if (voucher.isPresent()){
            throw new DuplicateRequestDataException("Voucher with the name " + req.getName() + " already exist");
        }

        VoucherType voucherType = voucherTypeRepository.findById(req.getVoucherTypeId())
                .orElseThrow(()-> new VoucherTypeNotFoundException(req.getVoucherTypeId()));

        String voucherCode = voucherService.generateUniqueVoucherCode(req.getName());

        return voucherRepository.save(req.toEntity(voucherCode, voucherType));
    }
}
