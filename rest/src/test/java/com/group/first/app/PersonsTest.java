package com.group.first.app;


import com.group.first.app.configuration.ConfigurationApplication;
import com.group.first.app.configuration.Loading;
import com.group.first.app.facade.PersonFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootConfiguration
@TestPropertySource(locations = "classpath:config/application.yaml")
@EnableConfigurationProperties({Loading.class, ConfigurationApplication.class })
@ComponentScan(basePackages = "com.group.first.app")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonsTest {

    @Autowired
    PersonFacade personFacade;

    @Test
    public void testTest() {

    }

    @Test
    public void addTest() {

    }
}
