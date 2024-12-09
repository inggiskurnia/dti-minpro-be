package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.User;
import com.miniproject.eventure.entity.user.UserVoucher;
import com.miniproject.eventure.entity.voucher.Voucher;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CreateUserVoucherRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long voucherId;

    public UserVoucher toEntity(User user, Voucher voucher, OffsetDateTime expiryAt) {
        UserVoucher userVoucher = new UserVoucher();
        userVoucher.setUser(user);
        userVoucher.setVoucher(voucher);
        userVoucher.setExpiredAt(expiryAt);
        return userVoucher;
    }
}
