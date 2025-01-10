package com.miniproject.eventure.usecase.user;

import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.infrastructure.user.dto.CreateUserVoucherRequestDTO;

public interface CreateUserVoucherUseCase {
    UserVoucher createUserVoucher(Long userId,CreateUserVoucherRequestDTO req);
}
