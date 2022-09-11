package com.cosmetelogy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CosmetologyControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handle(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry, we have some problem now. Please try later.");
    }
}
