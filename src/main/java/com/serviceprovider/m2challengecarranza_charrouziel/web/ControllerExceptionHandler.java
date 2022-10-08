package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.serviceprovider.m2challengecarranza_charrouziel.errors.CustomErrorResponse;
import com.serviceprovider.m2challengecarranza_charrouziel.errors.exception.ArgumentIsNotANumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Code from Class on October 5 2022 Regarding custom handlers
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<CustomErrorResponse> handleOutOfRangeException(IllegalArgumentException ex) {
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());

        ResponseEntity<CustomErrorResponse> returnVal = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return returnVal;
    }
    @ExceptionHandler(value = {ArgumentIsNotANumberException.class})
    public ResponseEntity<CustomErrorResponse> handleNotANumberException(ArgumentIsNotANumberException ex) {

        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());

        ResponseEntity<CustomErrorResponse> returnVal = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return returnVal;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<CustomErrorResponse> handleNotANumberHttpRequestException(HttpMessageNotReadableException ex) {

        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());

        ResponseEntity<CustomErrorResponse> returnVal = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return returnVal;
    }
}