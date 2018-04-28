package com.group.first.app.controller;

import com.group.first.app.dto.Echo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ganichev on 4/28/2018.
 */
@RestController
public class AppController {


    @RequestMapping(path = "car", method = RequestMethod.POST)
    public void car(){
        Echo echo = new Echo();
        echo.setMessage("test echo app");
    }


}
