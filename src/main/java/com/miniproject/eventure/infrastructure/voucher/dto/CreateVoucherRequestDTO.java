package com.miniproject.eventure.infrastructure.voucher.dto;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.entity.voucher.VoucherType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateVoucherRequestDTO {

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    private String description;

    @Min(0)
    private Integer totalCapacity;

    @Min(0)
    private Integer totalAvailable;

    private String validityPeriod;

    @NotNull
    private Long voucherTypeId;

    public Voucher toEntity(String code, VoucherType voucherType) {
        Voucher voucher = new Voucher();
        voucher.setCode(code);
        voucher.setName(this.name);
        voucher.setAmount(this.amount);
        voucher.setDescription(this.description);
        voucher.setTotalCapacity(this.totalCapacity);
        voucher.setTotalAvailable(this.totalAvailable);
        voucher.setValidityPeriod(this.validityPeriod);
        voucher.setVoucherType(voucherType);
        return voucher;
    }
}
