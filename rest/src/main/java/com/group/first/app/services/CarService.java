package com.group.first.app.services;

import com.group.first.app.dao.CarDAO;
import com.group.first.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDAO carDAO;

    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    public Car getCar(Long carId) {
        return carDAO.getCar(carId);
    }

    public List<Car> getOunerCars(Long ounerId) {
        return carDAO.getOunerCars(ounerId);
    }

    public void clearAllCars() {
        carDAO.clearAll();
    }

}
