package com.group.first.app.controller;

import com.group.first.app.exception.PersonIdException;

import com.group.first.app.exception.PersonValidateException;

import com.group.first.app.facade.PersonFacade;
import com.group.first.app.facade.StatisticFacade;
import com.group.first.app.model.Car;
import com.group.first.app.exception.CarValidateException;
import com.group.first.app.facade.CarFacade;
import com.group.first.app.model.PersonWithCars;
import com.group.first.app.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;


/**
 * Created by Ganichev on 4/28/2018.
 */
@RestController
public class AppController {

    @Autowired
    CarFacade carFacade;

    @Autowired
    StatisticFacade statisticFacade;

    @Autowired
    PersonFacade personFacade;



    @RequestMapping(path = "car", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> car(Car car){
        try {
            carFacade.addCar(car);
        } catch (CarValidateException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(path = "statistics", method = RequestMethod.GET)
    @ResponseBody
    public Statistics getStatistics(){
        return statisticFacade.getStatistic();
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public void addPerson(@RequestBody String personJson){
        try {
            personFacade.addPerson(personJson);
        } catch (IOException | PersonValidateException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/personwithcars", method = RequestMethod.POST)
    public PersonWithCars getPersonWithCars(@RequestParam Long id){
        try {
            PersonWithCars personWithCars = personFacade.getPersonWithCars(id);
            return personWithCars;
        } catch (PersonIdException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(path = "clear", method = RequestMethod.GET)
    @ResponseBody
    public void clear() {
        carFacade.clearAllCars();

    }

    @RequestMapping(path = "personwithcars", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PersonWithCars> getPersonWithCarsNon(@RequestParam(value = "personid", required = true) Long personId){
        try {
            PersonWithCars personWithCars = personFacade.getPersonWithCars(personId);
            if (personWithCars == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(personWithCars, HttpStatus.OK);
        } catch (PersonIdException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
