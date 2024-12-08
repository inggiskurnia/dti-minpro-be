package com.miniproject.eventure.usecase.voucher.impl;

import com.miniproject.eventure.common.exeptions.EventNotFoundException;
import com.miniproject.eventure.common.exeptions.VoucherTypeNotFoundException;
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

@Service
public class CreateVoucherUseCaseImpl implements CreateVoucherUseCase {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    VoucherTypeRepository voucherTypeRepository;

    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public Voucher createVoucher(CreateVoucherRequestDTO req) {
        Event event = eventRepository.findById(req.getEventId())
                .orElseThrow(()-> new EventNotFoundException(req.getEventId()));

        VoucherType voucherType = voucherTypeRepository.findById(req.getVoucherTypeId())
                .orElseThrow(()-> new VoucherTypeNotFoundException(req.getVoucherTypeId()));

        return voucherRepository.save(req.toEntity(event, voucherType));
    }
}
