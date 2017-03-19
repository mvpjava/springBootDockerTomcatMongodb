package com.mvpjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoLoggerService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoLoggerService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    public void logToMongo(LogRecord logRecord){
        mongoTemplate.save(logRecord, "logs");
    }
    
    public long getHomePageHitCount(){
        return mongoTemplate.count(new Query(), LogRecord.class, "logs");
    }

}
