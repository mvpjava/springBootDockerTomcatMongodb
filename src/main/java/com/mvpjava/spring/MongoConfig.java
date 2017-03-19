package com.mvpjava.spring;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration 
public class MongoConfig {
    private static final String MONGO_HOST = "mongo"; //populated via linked container
    private static final String MONGO_DB_NAME = "demo"; 

    private String mongoEnv; 
    
    @Bean 
    public MongoDbFactory mongoDbFactory() throws Exception {
        int port = parseMongoEnvForPort();
        MongoClient mongoClient = new MongoClient(MONGO_HOST, port);
        return new SimpleMongoDbFactory(mongoClient, MONGO_DB_NAME);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;

    }

    public String getMongoEnv() {
        return this.mongoEnv;
    }

    @Value("${MONGO_PORT}")
    public void setMongoEnv(String mongoPortEnvVar) {
        this.mongoEnv = mongoPortEnvVar;
    }

    
    ////////////////////////////  PRIVATE /////////////////////////////////////
    
    private int parseMongoEnvForPort() {
        //comes in format "tcp://172.17.0.3:27017 therefore extract port token only
        String[] tokens = getMongoEnv().split(":");   
        return Integer.parseInt(tokens[2]);
    }
    
    
}
