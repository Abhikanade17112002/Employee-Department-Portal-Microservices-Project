package com.departmentservice.exceptions;
import com.departmentservice.dtos.ApiErrorResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
        ApiErrorResponseDTO response = new ApiErrorResponseDTO() ;
        response.setMessage(ex.getMessage());
        response.setTimestamp( LocalDateTime.now());
        response.setStatus((HttpStatus) ex.getStatusCode());

        return ResponseEntity.ok( response ) ;
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleEntityNotFoundException(RuntimeException ex) {
        ApiErrorResponseDTO response = new ApiErrorResponseDTO() ;
        response.setMessage(ex.getMessage());
        response.setTimestamp( LocalDateTime.now());
        response.setStatus(  HttpStatus.NOT_FOUND  );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response) ;
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponseDTO> handleRuntimeErrors(RuntimeException ex) {
        ApiErrorResponseDTO response = new ApiErrorResponseDTO() ;
        response.setMessage(ex.getMessage());
        response.setTimestamp( LocalDateTime.now());
        response.setStatus(  HttpStatus.BAD_GATEWAY  );

        return ResponseEntity.ok( response ) ;
    }
}
