package com.userauthapi.userauth.controller;

import com.userauthapi.userauth.dto.ErrorDto;
import com.userauthapi.userauth.exception.NotFoundException;
import com.userauthapi.userauth.exception.UnauthorizedUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(NotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorDto(ex.getMessage()));
    }

    @ExceptionHandler(exception = UnauthorizedUserException.class)
    public ResponseEntity<ErrorDto> unauthorizedUserException(UnauthorizedUserException ex){
        return ResponseEntity.status(401).body(new ErrorDto(ex.getMessage()));
    }
}
