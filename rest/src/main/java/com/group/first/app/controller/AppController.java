package com.group.first.app.controller;

import com.group.first.app.facade.StatisticFacade;
import com.group.first.app.model.Car;
import com.group.first.app.exception.CarValidateException;
import com.group.first.app.facade.CarFacade;
import com.group.first.app.model.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ganichev on 4/28/2018.
 */
@RestController
public class AppController {

    @Autowired
    CarFacade carFacade;

    @Autowired
    StatisticFacade statisticFacade;



    @RequestMapping(path = "car", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> car(Car car){
        try {
            carFacade.addCar(car);
        } catch (CarValidateException e) {
            e.printStackTrace();
            // вернуть 400

            //return new ResponseEntity<String>();
        }
        return null;
    }


    @RequestMapping(path = "car", method = RequestMethod.POST)
    @ResponseBody
    public Statistics getStatistics(){
        return statisticFacade.getStatistic();
    }


}
