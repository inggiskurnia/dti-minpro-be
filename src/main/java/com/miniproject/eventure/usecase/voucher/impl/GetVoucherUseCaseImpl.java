package com.miniproject.eventure.usecase.voucher.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.voucher.dto.GetVoucherResponseDTO;
import com.miniproject.eventure.infrastructure.voucher.repository.VoucherRepository;
import com.miniproject.eventure.usecase.voucher.GetVoucherUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetVoucherUseCaseImpl implements GetVoucherUseCase {
    @Autowired
    VoucherRepository voucherRepository;

    @Override
    public List<GetVoucherResponseDTO> getEventVoucher(Long eventId) {
        List<Voucher> vouchers = voucherRepository.findByEventEventId(eventId);

        if (vouchers.isEmpty()){
            throw new DataNotFoundException("Voucher not found");
        }

        return vouchers.stream().map(GetVoucherResponseDTO::new).toList();
    }
}
