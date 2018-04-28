package com.group.first.app.facade;

import com.group.first.app.dao.PersonDAO;
import com.group.first.app.exception.PersonIdException;
import com.group.first.app.exception.PersonValidateException;
import com.group.first.app.model.Car;
import com.group.first.app.model.Person;
import com.group.first.app.model.PersonWithCars;
import com.group.first.app.services.CarService;
import com.group.first.app.services.PersonService;
import com.group.first.app.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonFacade {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PersonService personService;



    @Autowired
    private CarService carService;

    public void addPerson(String personJson) throws IOException, PersonValidateException, PersonIdException {
        Person person = validationService.personPacanckyValidarot(personJson);
        personService.addPerson(person);

    }



    public PersonWithCars getPersonWithCars(Long id) throws PersonIdException {
        validationService.personIdValidator(id);
        PersonWithCars personWithCars = null;
        Person person = personService.getPerson(id);
        if (person != null) {
            List<Car> cars = carService.getOunerCars(person.getId());
            personWithCars = new PersonWithCars(person);
            personWithCars.setCars(cars);
        }
        return personWithCars;
    }

    public void clearAllPerson(){
        personService.clearAllPerson();
    }

}