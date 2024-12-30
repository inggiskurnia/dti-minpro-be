package com.miniproject.eventure.usecase.voucher.impl;

import com.miniproject.eventure.common.exeptions.DataNotFoundException;
import com.miniproject.eventure.common.exeptions.VoucherNotFoundException;
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
    public GetVoucherResponseDTO getVoucherById(Long voucherId) {
        Voucher voucher = voucherRepository.findById(voucherId).orElseThrow(VoucherNotFoundException::new);
        return new GetVoucherResponseDTO(voucher);
    }

    @Override
    public List<GetVoucherResponseDTO> getAllVoucher() {
        return voucherRepository.findAll().stream().map(GetVoucherResponseDTO::new).toList();
    }
}
