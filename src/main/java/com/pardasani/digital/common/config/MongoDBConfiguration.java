package com.pardasani.digital.common.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.function.Function;

/**
 * Created by pankajpardasani on 03/03/2016.
 */
@Configuration
@EnableMongoRepositories
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    String db;

    @Value("${spring.data.mongodb.host}")
    String dbServer;

    @Value("${spring.data.mongodb.port}")
    String dbPort;

    @Value("${mongodb.connections.per.host}")
    String connectionsPerHost;

    @Value("${mongodb.heartbeat.frequency}")
    String heartbeatFrequency;

    @Value("${mongodb.minimum.connections.per.host}")
    String minConnectionsPerHost;

    @Value("${mongodb.connection.life}")
    String maxConnectionLifeTime;

    @Value("${mongodb.connection.timeout}")
    String connectTimeout;

    private static Function<String, Integer> intToString = (str) -> Integer.valueOf(str);

    @Bean public MongoClientOptions mongoClientOptions() throws Exception {
        return new MongoClientOptions.Builder()
                .connectionsPerHost(intToString.apply(connectionsPerHost))
                .heartbeatFrequency(intToString.apply(heartbeatFrequency))
                .minConnectionsPerHost(intToString.apply(minConnectionsPerHost))
                .maxConnectionLifeTime(intToString.apply(maxConnectionLifeTime))
                .connectTimeout(intToString.apply(connectTimeout))
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return db;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return mongoClient();
    }

    @Bean public MongoClient mongoClient() throws Exception {
        return new MongoClient(new ServerAddress(dbServer, intToString.apply(dbPort)), mongoClientOptions());
    }

    @Bean public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }
}
