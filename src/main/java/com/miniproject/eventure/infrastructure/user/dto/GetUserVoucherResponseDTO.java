package com.miniproject.eventure.infrastructure.user.dto;

import com.miniproject.eventure.entity.user.UserVoucher;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class GetUserVoucherResponseDTO {

    private Long userVoucherId;
    private Long voucherId;
    private String voucherCode;
    private String voucherName;
    private BigDecimal voucherAmount;
    private String voucherDescription;
    private String voucherType;
    private OffsetDateTime expiredAt;

    public GetUserVoucherResponseDTO(UserVoucher userVoucher) {
        this.userVoucherId = userVoucher.getUserVoucherId();
        this.voucherId = userVoucher.getVoucher().getVoucherId();
        this.voucherCode = userVoucher.getVoucher().getCode();
        this.voucherName = userVoucher.getVoucher().getName();
        this.voucherAmount = userVoucher.getVoucher().getAmount();
        this.voucherDescription = userVoucher.getVoucher().getDescription();
        this.voucherType = userVoucher.getVoucher().getVoucherType().getName();
        this.expiredAt = userVoucher.getExpiredAt();
    }
}
