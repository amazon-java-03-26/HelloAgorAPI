package com.ironhacker.helloagorapi.controller;

import com.ironhacker.helloagorapi.dto.ErrorDto;
import com.ironhacker.helloagorapi.exceptions.AgorApiException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    Review the lesson we did for HelloCrud2 -> Week 5 Day 2 - More CRUD

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    String field = error.getField();
                    String message = error.getDefaultMessage();
                    errors.computeIfAbsent(field, k -> new ArrayList<>())
                            .add(message);
                });

        return ResponseEntity
                .badRequest()
                .body(errors);
    }


    @ExceptionHandler(AgorApiException.class)
    public ResponseEntity<ErrorDto> handleAgorApiException(AgorApiException ex){
        return ResponseEntity.status(400).body(new ErrorDto(ex.getClass().getSimpleName(), ex.getMessage()));
    }
}
