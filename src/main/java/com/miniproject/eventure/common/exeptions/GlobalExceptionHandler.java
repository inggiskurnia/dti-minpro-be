package com.miniproject.eventure.common.exeptions;

import com.miniproject.eventure.common.responses.ApiResponse;
import lombok.extern.java.Log;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@Log
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDataAccessException(DataAccessException ex) {
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(DuplicateRequestDataException.class)
    public ResponseEntity<?> handleDuplicateRequestDataException(DuplicateRequestDataException ex) {
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(EmptyRequestDataException.class)
    public ResponseEntity<?> handleEmptyRequestDataException(EmptyRequestDataException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(UserVoucherNotFoundException.class)
    public ResponseEntity<?> handleUserVoucherNotFoundException(UserVoucherNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<?> handleTransactionNotFoundException(TransactionNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(EventTicketNotFoundException.class)
    public ResponseEntity<?> handleEventTicketNotFoundException(EventTicketNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<?> handleEventNotFoundException(EventNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<?> handleInvoiceNotFoundException(InvoiceNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(VoucherNotFoundException.class)
    public ResponseEntity<?> handleVoucherNotFoundException(VoucherNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(VoucherTypeNotFoundException.class)
    public ResponseEntity<?> handleVoucherTypeNotFoundException(VoucherTypeNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(StatusTypeNotFoundException.class)
    public ResponseEntity<?> StatusTypeNotFoundException(StatusTypeNotFoundException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex) {
        return ApiResponse.failed(HttpStatus.UNAUTHORIZED.value(), "Access denied");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        return ApiResponse.failed(ex.getMessage());
    }
}
