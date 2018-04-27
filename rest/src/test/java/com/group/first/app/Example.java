package com.group.first.app;

import com.group.first.app.configuration.Loading;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@SpringBootConfiguration
@TestPropertySource(locations = "classpath:config/application.yaml")
@EnableConfigurationProperties({Loading.class, })
@RunWith(SpringJUnit4ClassRunner.class)
public class Example {

    private static final Logger log = LoggerFactory.getLogger(Example.class);

    @Autowired
    protected Loading loading;

    @Before
    public void prepare(){
        log.info("Prepare test");
    }

    @Test
    public void simpleTest(){
        log.info("Start simple test with loading full value {}", loading.getFull());
        assertTrue(Boolean.TRUE);
    }

}
