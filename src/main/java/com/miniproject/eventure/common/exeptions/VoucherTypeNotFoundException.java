package com.miniproject.eventure.common.exeptions;

public class VoucherTypeNotFoundException extends RuntimeException {
    public VoucherTypeNotFoundException(Long voucherTypeId) {
        super("Voucher type with ID " + voucherTypeId + " not found !");
    }
}
