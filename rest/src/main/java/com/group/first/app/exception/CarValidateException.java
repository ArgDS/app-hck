package com.group.first.app.exception;

public class CarValidateException extends SimpleException {

    public CarValidateException(){
        super(" ");
    }
    public CarValidateException(String message) {
        super(message);
    }
}
