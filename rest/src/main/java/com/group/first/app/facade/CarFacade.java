package com.group.first.app.facade;

import com.group.first.app.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;

public class CarFacade {

    @Autowired
    ValidationService validationService;
}
