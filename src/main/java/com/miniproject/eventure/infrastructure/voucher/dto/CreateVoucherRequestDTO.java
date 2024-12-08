package com.miniproject.eventure.infrastructure.voucher.dto;

import com.miniproject.eventure.entity.event.Event;
import com.miniproject.eventure.entity.voucher.Voucher;
import com.miniproject.eventure.entity.voucher.VoucherType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateVoucherRequestDTO {

    @NotNull
    private String code;

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    private String description;

    @NotNull
    @Min(0)
    private Integer totalCapacity;

    @NotNull
    @Min(0)
    private Integer totalAvailable;

    @NotNull
    private LocalDateTime startedAt;

    @NotNull
    private LocalDateTime expiredAt;

    @NotNull
    private Long eventId;

    @NotNull
    private Long voucherTypeId;

    public Voucher toEntity(Event event, VoucherType voucherType) {
        Voucher voucher = new Voucher();
        voucher.setCode(this.code);
        voucher.setName(this.name);
        voucher.setAmount(this.amount);
        voucher.setDescription(this.description);
        voucher.setTotalCapacity(this.totalCapacity);
        voucher.setTotalAvailable(this.totalAvailable);
        voucher.setStartedAt(this.startedAt);
        voucher.setExpiredAt(this.expiredAt);
        voucher.setEvent(event);
        voucher.setVoucherType(voucherType);
        return voucher;
    }
}
