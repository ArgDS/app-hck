package com.group.first.app.services;

import com.group.first.app.dto.Car;
import com.group.first.app.exception.CarValidateException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidationService {

    public void validateCar(Car car) throws CarValidateException {

        if (car.getId() == null || car.getHorsePower() == null || car.getModel() == null || car.getOunerId() == null) {
            throw new CarValidateException("get null");
        }

        String model = car.getModel();

        Pattern pattern = Pattern.compile(".+-.+");
        if (!pattern.matcher(model).find()) {
            throw new CarValidateException("model pattern");
        }

    }





}
