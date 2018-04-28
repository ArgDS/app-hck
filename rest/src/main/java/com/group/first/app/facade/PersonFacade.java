package com.group.first.app.facade;

import com.group.first.app.exception.PersonValidateException;
import com.group.first.app.model.Person;
import com.group.first.app.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PersonFacade {

    @Autowired
    ValidationService validationService;

    void addPerson(String personJson) throws IOException, PersonValidateException {
        Person person = validationService.personPacanckyValidarot(personJson);

    }
}