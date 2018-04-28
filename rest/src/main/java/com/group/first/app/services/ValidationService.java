package com.group.first.app.services;

import com.group.first.app.dto.Car;
import com.group.first.app.exception.CarValidateException;

public class ValidationService {

    private void validateCar(Car car) throws CarValidateException {

        if (car.getId() == null || car.getHorsePower() == null || car.getModel() == null || car.getOunerId() == null) {
            throw new CarValidateException("get null");
        }




    }
}
