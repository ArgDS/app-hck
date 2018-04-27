package com.group.first.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * Created by DMikhailov on 25.01.2018.
 */


@Configuration
@PropertySource(value = "config/application.yaml")
@EnableConfigurationProperties({Loading.class, Elasticsearch.class, Monitoring.class})
public class ConfigurationApplication {

    @Autowired
    protected Loading loading;

    @Autowired
    protected Elasticsearch elasticsearch;

    @Autowired
    protected Monitoring monitoring;


    @Autowired
    protected Environment env;




    /*@Bean(name = "elasticsearchClient", destroyMethod = "close")
    public Client client(){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", elasticsearch.getClusterName())
                .put("node.client", true)
                .put("client.transport.sniff", elasticsearch.getSniffAddresses())
                .put("transport.connections_per_node.bulk", 6)
                .build();
        TransportClient client = new TransportClient(settings);
        elasticsearch.getHosts().forEach(host -> client.addTransportAddress(new InetSocketTransportAddress(host.getIp(), host.getPort())));
        return client;
    }

    @Bean(name = "bulkProcessor", destroyMethod = "close")
    public BulkProcessor bulkProcessor(@Autowired Client client){
        BulkProcessor bulkProcessor = BulkProcessor.builder(client, new SimpleBulkListener())
                .setBulkActions(elasticsearch.getBulk().getRequests())
                .setBulkSize(new ByteSizeValue(elasticsearch.getBulk().getSize(), ByteSizeUnit.MB))
                .setFlushInterval(TimeValue.timeValueMillis(elasticsearch.getBulk().getTimeout()))
                .setConcurrentRequests(elasticsearch.getBulk().getConcurrent())
                .build();
        return bulkProcessor;
    }*/

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(6);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("async-task-");
        executor.initialize();
        return executor;
    }

    /*@Bean(name = "dataSource")
    public DataSource monitoringDataSource(){
        return createDataSource(monitoring);
    }

    @Bean(name = "jdbcTemplate")
    public NamedParameterJdbcTemplate monitoringJdbcTemplate(@Autowired @Qualifier("monitoringDataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public DataSource createDataSource(AbstractConfigDataSource config){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(config.getUrl());
        hikariConfig.setDriverClassName(config.getDriverClass());
        hikariConfig.setUsername(config.getUser());
        hikariConfig.setPassword(config.getPassword());
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(2);
        return new HikariDataSource(hikariConfig);
    }*/
}
