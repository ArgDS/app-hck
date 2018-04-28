package com.group.first.app.dto;

public class CarDto {

    private Long id;
    private String model;
    private int horsePower;
    private Long OunerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public Long getOunerId() {
        return OunerId;
    }

    public void setOunerId(Long ounerId) {
        OunerId = ounerId;
    }
}
