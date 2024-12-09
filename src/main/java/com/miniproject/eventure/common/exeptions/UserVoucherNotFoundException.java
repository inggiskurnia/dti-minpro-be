package com.miniproject.eventure.common.exeptions;

public class UserVoucherNotFoundException extends RuntimeException {
    public UserVoucherNotFoundException() {
        super("User voucher not found !");
    }
}
