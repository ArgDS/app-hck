package com.group.first.app.model;

import java.util.ArrayList;
import java.util.List;

public class PersonWithCars extends Person {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
