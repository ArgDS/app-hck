package com.group.first.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db.monitoring")
public class Monitoring extends AbstractConfigDataSource{

}
