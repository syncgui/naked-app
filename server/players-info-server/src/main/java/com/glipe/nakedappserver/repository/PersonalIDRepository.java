package com.glipe.nakedappserver.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class PersonalIDRepository extends MongoRepository {

    private final String collection = "players_personal_ids";


    public boolean idAvailability(String id){
        try (MongoClient mongoClient = MongoClients.create()) {
           var idCollection = mongoClient.getDatabase(database)
                    .getCollection(collection);

            return idCollection
                    .find(eq("player_id", id))
                    .first().getBoolean("available");
        }
    }
}
