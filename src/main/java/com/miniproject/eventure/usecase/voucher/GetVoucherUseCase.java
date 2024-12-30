package com.miniproject.eventure.usecase.voucher;

import com.miniproject.eventure.infrastructure.voucher.dto.GetVoucherResponseDTO;

import java.util.List;

public interface GetVoucherUseCase {
    GetVoucherResponseDTO getVoucherById(Long voucherId);
    List<GetVoucherResponseDTO> getAllVoucher();
}
