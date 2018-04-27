package com.group.first.app.dto;

public class Error {
    private String message;
    private String classException;

    public Error(String message, String classException) {
        this.message = message;
        this.classException = classException;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClassException() {
        return classException;
    }

    public void setClassException(String classException) {
        this.classException = classException;
    }
}
