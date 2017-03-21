package com.mvpjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main extends SpringBootServletInitializer {

    @Autowired
    MongoService mongoLoggerSerive;

    @RequestMapping("/")
    public String home() {
        mongoLoggerSerive.logToMongo(new LogRecord("INFO", "New Home page hit"));
        return "Spring Boot war deployment in Tomcat Docker Container successfull <P>" +
                mongoLoggerSerive.getMongoDbInfo();
    }

    @RequestMapping("/hits")
    public String getHomePageHits() {
        long homePageHitCount = mongoLoggerSerive.getHomePageHitCount();
        return "The Home page has been hit " +  homePageHitCount + " times";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Main.class); //web.xml
    }

}
