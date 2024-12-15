package com.miniproject.eventure.usecase.voucher;

import com.miniproject.eventure.infrastructure.voucher.dto.GetVoucherResponseDTO;

import java.util.List;

public interface GetVoucherUseCase {
    List<GetVoucherResponseDTO> getEventVoucher(Long eventId);
    GetVoucherResponseDTO getVoucherById(Long voucherId);
}
