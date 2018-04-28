package com.group.first.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db.autodb")
public class AutoDatabase extends AbstractConfigDataSource{

}
