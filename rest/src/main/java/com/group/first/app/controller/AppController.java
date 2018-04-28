package com.group.first.app.controller;

import com.group.first.app.dto.Echo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AppController {


    @RequestMapping(path = "echoApp", method = RequestMethod.GET)
    public Echo echo(){
        Echo echo = new Echo();
        echo.setMessage("test echo app");
        return echo;
    }


}
