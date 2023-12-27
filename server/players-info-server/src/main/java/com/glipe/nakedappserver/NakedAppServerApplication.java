package com.glipe.nakedappserver;

import com.mongodb.client.MongoCollection;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
public class NakedAppServerApplication { public static void main(String[] args) {SpringApplication.run(NakedAppServerApplication.class, args);}}
