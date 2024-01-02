package com.glipe.playersinfoserver.repository;

import com.glipe.playersinfoserver.model.PlayerInfo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.InsertOneResult;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository extends MongoRepository{
    private final String collection = "players_info";

    public boolean insertPlayer(PlayerInfo playerInfo){
        try (MongoClient mongoClient = MongoClients.create(mongoDBuri)) {
            var playerCollection = mongoClient
                    .getDatabase(database)
                    .getCollection(collection);

            InsertOneResult insertResult = playerCollection.insertOne(playerInfo);

            return insertResult.getInsertedId() != null;
        }
    }
}