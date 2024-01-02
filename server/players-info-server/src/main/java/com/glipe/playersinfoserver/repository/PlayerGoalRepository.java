package com.glipe.playersinfoserver.repository;

import com.glipe.playersinfoserver.model.PlayerGoal;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.InsertOneResult;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerGoalRepository extends MongoRepository{
    private final String collection = "players_goals";

    public boolean insertGoal(PlayerGoal playerGoal) {
        try (MongoClient mongoClient = MongoClients.create(mongoDBuri)) {
            var playerCollection = mongoClient
                    .getDatabase(database)
                    .getCollection(collection);

            InsertOneResult insertResult = playerCollection.insertOne(playerGoal);

            return insertResult.getInsertedId() != null;
        }
    }
}