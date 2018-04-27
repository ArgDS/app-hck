package com.group.first.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db.gfdb")
public class Database extends AbstractConfigDataSource{

}
