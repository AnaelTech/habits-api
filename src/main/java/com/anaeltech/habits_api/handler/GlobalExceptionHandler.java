package com.anaeltech.habits_api.handler;

import java.time.Instant;
import com.anaeltech.habits_api.exception.storage.StorageFileNotFoundException;
import com.anaeltech.habits_api.exception.storage.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anaeltech.habits_api.dto.api.response.ErrorResponse;
import com.anaeltech.habits_api.exception.user.UserNotFoundException;
import com.anaeltech.habits_api.exception.user.UserPasswordDoesNotMatchException;
import com.anaeltech.habits_api.exception.user.UserEmailAlreadyExistException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(UserEmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(UserEmailAlreadyExistException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(buildErrorResponse(HttpStatus.CONFLICT, ex.getMessage()));
    }

    @ExceptionHandler(UserPasswordDoesNotMatchException.class)
    public ResponseEntity<ErrorResponse> handleUserPasswordDoesNotMatchException(
            UserPasswordDoesNotMatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStorageFileNotFoundException(StorageFileNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ErrorResponse> handleStorageException(StorageException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    private ErrorResponse buildErrorResponse(HttpStatus status, String message) {
        return new ErrorResponse(
                status.value(),
                message,
                Instant.now().toString());
    }
}
