package com.glipe.playersinfoserver.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class PersonalIDRepository extends MongoRepository {

    private final String collection = "players_personal_ids";

    public boolean idAvailability(String id) {
        try (MongoClient mongoClient = MongoClients.create(mongoDBuri)) {
            var idCollection = mongoClient.getDatabase(database)
                    .getCollection(collection);

            return idCollection
                    .find(eq("personal_id", id))
                    .first().getBoolean("available");
        }
    }

    public void changeIdAvailability(String id) {
        try (MongoClient mongoClient = MongoClients.create(mongoDBuri)) {
            var idCollection = mongoClient.getDatabase(database)
                    .getCollection(collection);

            idCollection.updateOne(new Document("personal_id", id),
                    new Document("$set", new Document("available", false)));
        }
    }
}