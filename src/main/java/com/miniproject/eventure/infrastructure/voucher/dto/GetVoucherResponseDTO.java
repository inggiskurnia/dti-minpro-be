package com.miniproject.eventure.infrastructure.voucher.dto;

import com.miniproject.eventure.entity.voucher.Voucher;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class GetVoucherResponseDTO {

    private Long voucherId;
    private String code;
    private String name;
    private BigDecimal amount;
    private String description;
    private Integer totalCapacity;
    private Integer totalAvailable;
    private String validityPeriod;
    private Long voucherTypeId;
    private String voucherTypeName;

    public GetVoucherResponseDTO(Voucher voucher) {
        this.voucherId = voucher.getVoucherId();
        this.code = voucher.getCode();
        this.name = voucher.getName();
        this.amount = voucher.getAmount();
        this.description = voucher.getDescription();
        this.totalCapacity = voucher.getTotalCapacity();
        this.totalAvailable = voucher.getTotalAvailable();
        this.validityPeriod = voucher.getValidityPeriod();
        this.voucherTypeId = voucher.getVoucherType().getVoucherTypeId();
        this.voucherTypeName = voucher.getVoucherType().getName();
    }
}
