package com.miniproject.eventure.common.exeptions;

public class VoucherNotFoundException extends RuntimeException {
    public VoucherNotFoundException() {
        super("Voucher code not found");
    }
}
