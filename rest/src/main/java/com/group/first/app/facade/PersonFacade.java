package com.group.first.app.facade;

import com.group.first.app.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonFacade {

    @Autowired
    ValidationService validationService;

    void addPerson(String personJson){
        validationService
    }
}