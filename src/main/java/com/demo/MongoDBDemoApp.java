package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.demo"})
@EnableMongoRepositories("com.demo")
public class MongoDBDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(MongoDBDemoApp.class, args);
    }

}
