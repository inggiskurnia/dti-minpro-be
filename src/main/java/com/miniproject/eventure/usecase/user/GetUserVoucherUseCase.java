package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.infrastructure.user.dto.GetUserVoucherResponseDTO;

import java.util.List;

public interface GetUserVoucherUseCase {
    List<GetUserVoucherResponseDTO> getUserVoucher(Long userId);
    GetUserVoucherResponseDTO getUserVoucherByVoucherID(Long userId, Long voucherId);
}

