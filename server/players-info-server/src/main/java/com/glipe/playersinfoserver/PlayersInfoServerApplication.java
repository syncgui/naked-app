package com.glipe.playersinfoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
public class PlayersInfoServerApplication { public static void main(String[] args) {SpringApplication.run(PlayersInfoServerApplication.class, args);}}
