package com.group.first.app.model;

public class Car {

    private Long id;
    private String model;
    private Integer horsePower;
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

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Long getOunerId() {
        return OunerId;
    }

    public void setOunerId(Long ounerId) {
        OunerId = ounerId;
    }
}
