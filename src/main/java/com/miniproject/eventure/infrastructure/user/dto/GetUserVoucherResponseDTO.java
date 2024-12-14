package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.UserVoucher;
import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class GetUserVoucherResponseDTO {

    private Long userVoucherId;
    private Long userId;
    private String userName;
    private Long voucherId;
    private String voucherCode;
    private String voucherName;
    private OffsetDateTime expiredAt;
    private OffsetDateTime usedAt;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;

    public GetUserVoucherResponseDTO(UserVoucher userVoucher) {
        this.userVoucherId = userVoucher.getUserVoucherId();
        this.userId = userVoucher.getUser().getUserId();
        this.userName = userVoucher.getUser().getFullName();
        this.voucherId = userVoucher.getVoucher().getVoucherId();
        this.voucherCode = userVoucher.getVoucher().getCode();
        this.voucherName = userVoucher.getVoucher().getName();
        this.expiredAt = userVoucher.getExpiredAt();
        this.usedAt = userVoucher.getUsedAt();
        this.createdAt = userVoucher.getCreatedAt();
        this.updatedAt = userVoucher.getUpdatedAt();
        this.deletedAt = userVoucher.getDeletedAt();
    }
}
