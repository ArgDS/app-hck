package com.group.first.app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "elasticsearch_store")
@Validated
public class Elasticsearch {

    @NotNull
    private String clusterName;
    private String indexName;
    private Boolean sniffAddresses;
    private Integer connectionsPerNode;
    private List<Host> hosts = new ArrayList<>();
    private Bulk bulk = new Bulk();

    public static class Host {
        private String ip;
        private Integer port;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }

    public static class Bulk {
        private Integer size;
        private Integer requests;
        private Integer timeout;
        private Integer concurrent;

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getRequests() {
            return requests;
        }

        public void setRequests(Integer requests) {
            this.requests = requests;
        }

        public Integer getTimeout() {
            return timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getConcurrent() {
            return concurrent;
        }

        public void setConcurrent(Integer concurrent) {
            this.concurrent = concurrent;
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("elasticsearch init");
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public Boolean getSniffAddresses() {
        return sniffAddresses;
    }

    public void setSniffAddresses(Boolean sniffAddresses) {
        this.sniffAddresses = sniffAddresses;
    }

    public Integer getConnectionsPerNode() {
        return connectionsPerNode;
    }

    public void setConnectionsPerNode(Integer connectionsPerNode) {
        this.connectionsPerNode = connectionsPerNode;
    }

    public List<Host> getHosts() {
        return hosts;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    public Bulk getBulk() {
        return bulk;
    }

    public void setBulk(Bulk bulk) {
        this.bulk = bulk;
    }

}
