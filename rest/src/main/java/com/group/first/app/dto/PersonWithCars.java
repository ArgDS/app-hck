package com.group.first.app.dto;

import com.group.first.app.model.Car;
import com.group.first.app.model.Person;

import java.util.List;

/**
 * Created by Ganichev on 4/28/2018.
 */
public class PersonWithCars {
    Person person;
    List<Car> carList;

    public PersonWithCars(Person person, List<Car> carList) {
        this.person = person;
        this.carList = carList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
