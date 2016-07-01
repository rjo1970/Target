package com.target.myretail.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.target.myretail.repositories")
@PropertySource("classpath:mongo.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MongoConfiguration.class);

    @Value("${mongo.host}")
    private String host;
    
    @Value("${mongo.port}")
    private Integer port;
    
    @Value("${mongo.dbname}")
    private String dbName;
    
    @Override
    protected String getDatabaseName() {
        log.info("***** dbName: " + dbName);
        return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        log.info("***** host: " + host + "; port: " + port);
        return new MongoClient(host, port);
    }
}
