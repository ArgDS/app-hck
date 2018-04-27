package com.group.first.app.dto;

import java.io.Serializable;

public class Echo implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
