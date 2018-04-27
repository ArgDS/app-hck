package com.group.first.app.controller;

import com.group.first.app.exception.SimpleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.group.first.app.dto.Error;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({SimpleException.class})
    public ResponseEntity<Error> notFoundSessionDataFacade(Exception throwable, WebRequest request){
        Error error = new Error(throwable.getMessage(), throwable.getClass().getName());
        return ResponseEntity.ok(error);
    }
}
