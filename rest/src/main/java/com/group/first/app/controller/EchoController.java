package com.group.first.app.controller;

import com.group.first.app.dto.Echo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @RequestMapping(path = "echo", method = RequestMethod.GET)
    public Echo echo(){
        Echo echo = new Echo();
        echo.setMessage("test echo app");
        return echo;
    }

}
