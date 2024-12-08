package com.miniproject.eventure.usecase.voucher;

import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.infrastructure.voucher.dto.CreateVoucherRequestDTO;

public interface CreateVoucherUseCase {
    Voucher createVoucher(CreateVoucherRequestDTO req);
}
