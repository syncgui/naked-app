package com.glipe.nakedappserver.repository;

import org.springframework.beans.factory.annotation.Value;

public abstract class MongoRepository {
     @Value("${mongodb.connection.uri}")
     String mongoDBuri;

     final String database = "players" ;
}
