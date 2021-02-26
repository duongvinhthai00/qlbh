package com.quanlybanhang.qlbh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse NotFoundExceptionHandler(NotFoundException ex , WebRequest web){
        return new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    @ExceptionHandler(ExceptionGobal.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse ExistedExceptionHandler(ExceptionGobal ex , WebRequest web){
        return new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getMessage());
    }
}
