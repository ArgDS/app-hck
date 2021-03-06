package com.group.first.app.facade;

import com.group.first.app.model.Car;
import com.group.first.app.exception.CarValidateException;
import com.group.first.app.services.CarService;
import com.group.first.app.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarFacade {

    @Autowired
    ValidationService validationService;

    @Autowired
    CarService carService;

    @Autowired
    StatisticFacade statisticFacade;

    public void addCar(Car car) throws CarValidateException {
        validationService.validateCar(car);
        carService.addCar(car);
    }

    public void clearAllCars() {
        carService.clearAllCars();
    }

}
