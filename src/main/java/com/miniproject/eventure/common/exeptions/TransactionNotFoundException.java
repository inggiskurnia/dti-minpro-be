package com.miniproject.eventure.common.exeptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException() {
        super("Transaction with transaction ID not found !");
    }
}
