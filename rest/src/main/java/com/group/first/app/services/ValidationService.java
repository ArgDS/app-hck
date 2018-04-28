package com.group.first.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.first.app.dto.Car;
import com.group.first.app.exception.CarValidateException;
import com.group.first.app.exception.PersonValidateException;
import com.group.first.app.model.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ValidationService {
    private ObjectMapper mapper;


    public ValidationService(){
        mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
    }

    public void validateCar(Car car) throws CarValidateException {

        if (car.getId() == null || car.getHorsePower() == null || car.getModel() == null || car.getOunerId() == null) {
            throw new CarValidateException("get null");
        }




    }



    public Person personPacanckyValidarot(String personJson) throws PersonValidateException, IOException {
        Person person = mapper.readValue(personJson, Person.class);
        if (person.getBirthdate().getTime() > new Date().getTime()){
            throw new PersonValidateException("Дата больше текущего времени");
        }
        //todo и тут еще проверка из базы на существование
        return person;
    }



}
