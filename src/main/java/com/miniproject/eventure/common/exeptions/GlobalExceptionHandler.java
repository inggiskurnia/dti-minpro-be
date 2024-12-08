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

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex) {
        return ApiResponse.failed(HttpStatus.UNAUTHORIZED.value(), "Access denied");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        return ApiResponse.failed(ex.getMessage());
    }
}
