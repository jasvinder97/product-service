package com.example.demo.exception;

/**
@ResponseStatus(HttpStatus.CONFLICT)   will set error status as conflict everytime exception occurred*/
public class ProductException extends RuntimeException {

    public ProductException(String s) {
        super(s);
    }
}
