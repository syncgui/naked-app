package com.glipe.nakedappserver.repository;

import com.glipe.nakedappserver.model.PlayerInfo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.InsertOneResult;
import org.springframework.stereotype.Repository;


@Repository
public class PlayerRepository extends MongoRepository{
    private final String collection = "player_info";

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
