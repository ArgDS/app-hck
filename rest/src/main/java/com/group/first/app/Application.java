package com.group.first.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application implements ApplicationRunner{

    public static final void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.setAddCommandLineProperties(true);
        application.setWebEnvironment(true);
        application.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
