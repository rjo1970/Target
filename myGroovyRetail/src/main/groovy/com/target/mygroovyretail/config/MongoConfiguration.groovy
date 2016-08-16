package com.target.mygroovyretail.config

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by jrtitko1 on 8/6/16.
 */
@Configuration
@EnableMongoRepositories("com.target.mygroovyretail.repositories")
@PropertySource("classpath:mongo.properties")
class MongoConfiguration extends AbstractMongoConfiguration {

    static Logger log = Logger.getLogger(MongoConfiguration.class)

    @Value('${mongo.host}')
    String host;

    @Value('${mongo.port}')
    Integer port;

    @Value('${mongo.dbname}')
    String dbName;

    @Override
    protected String getDatabaseName() {
        log.info("***** dbName: $dbName")
        return dbName
    }

    @Override
    Mongo mongo() throws Exception {
        log.info("***** host: $host; port: $port")
        return new MongoClient(host, port)
    }
}
