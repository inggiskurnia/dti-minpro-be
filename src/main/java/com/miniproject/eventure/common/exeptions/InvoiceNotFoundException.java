package com.miniproject.eventure.common.exeptions;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(String invoiceNumber) {
        super("Transaction with invoice number " + invoiceNumber + " not found !");
    }
}
