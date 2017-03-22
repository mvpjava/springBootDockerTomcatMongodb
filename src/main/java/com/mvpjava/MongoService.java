package com.mvpjava;

import java.util.Date;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    public void logToMongo(LogRecord logRecord){
        logRecord.setDate(new Date());
        mongoTemplate.save(logRecord, "logs");
    }
    
    public long getHomePageHitCount(){
        return mongoTemplate.count(new Query(), LogRecord.class, "logs");
    }
    
    public String getMongoDbInfo(){
        String dbName = mongoTemplate.getDb().getName();
        Set<String> collectionNames = mongoTemplate.getCollectionNames();
        
        StringBuilder builder = new  StringBuilder("Connecting to MongoDB database [").
                append(dbName).append("] ");
        
        for (String collectionName : collectionNames) {
            builder.append("Containing Collection [").
                    append(collectionName).
                    append("]");
        }
        
        return builder.toString();       
    }

}
