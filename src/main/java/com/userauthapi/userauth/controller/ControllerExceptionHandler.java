package com.userauthapi.userauth.controller;

import com.userauthapi.userauth.dto.ErrorDto;
import com.userauthapi.userauth.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(NotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorDto(ex.getMessage()));
    }
}
