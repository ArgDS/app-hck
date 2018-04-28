package com.group.first.app.services;

import com.group.first.app.dao.PersonDAO;
import com.group.first.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public void addPerson(Person person){
        personDAO.addPerson(person);
    }

    public Person getPerson(long id){
        return personDAO.getPerson(id);
    }

    public void clearAllPerson() {
        personDAO.clearAllPersons();
    }
}
