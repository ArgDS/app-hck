package com.group.first.app.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * Created by DMikhailov on 31.01.2018.
 */
@ConfigurationProperties
@Validated
public class Loading {


    private String full;


    private Duration dFull;


    @PostConstruct
    void init(){
        dFull = Duration.parse(full);

    }

    public Duration getFullDuration() {
        return dFull;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

}
