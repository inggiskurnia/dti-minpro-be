package com.miniproject.eventure.common.exeptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long transactionId) {
        super("Transaction with transaction ID " + transactionId + " not found !");
    }
}
