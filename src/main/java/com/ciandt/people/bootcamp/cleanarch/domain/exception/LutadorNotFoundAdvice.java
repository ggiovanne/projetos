package com.ciandt.people.bootcamp.cleanarch.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class LutadorNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(LutadorNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(LutadorNotFoundException ex) {
    return ex.getMessage();
  }
}