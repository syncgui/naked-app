package com.glipe.nakedappserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glipe.nakedappserver.config.MongoDBConnection;
import com.glipe.nakedappserver.config.RandomAvailableLetters;
import com.glipe.nakedappserver.model.PlayerInfo;
import com.mongodb.client.result.InsertOneResult;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.mongodb.client.model.Filters.eq;


@Service
@RequiredArgsConstructor
public class PlayerInfoService {

    private final String[] availableLetters = RandomAvailableLetters.randomAvailableLetters;

    private final MongoDBConnection mongoDBConnection;

    private final ObjectMapper objectMapper;


    public PlayerInfo createPlayerInfo(PlayerInfo playerInfo) throws JsonProcessingException {

        String generatedID = randomPlayerID();
        playerInfo.setPlayerID(generatedID);

        Document document = Document.parse(objectMapper.writeValueAsString(playerInfo));

        var collection = mongoDBConnection.getDatabaseConnection("players")
                .getCollection("player_info");

        InsertOneResult insertResult = collection.insertOne(document);

        if (insertResult.getInsertedId() == null) {
            throw new RuntimeException();
        }
        return playerInfo;
    }

    private String randomPlayerID() {

        var generatedId = generateNumberLetter();
        while (!isIdAvailable(generatedId)) {
            generatedId = generateNumberLetter();
        }

        return generatedId;
    }

    private String generateNumberLetter() {
        Random random = new Random();
        var alphabetIndex = random.nextInt(0, 25);
        var generatedNumber = random.nextInt(0, 9);
        String generatedLetter = availableLetters[alphabetIndex];

        var generatedId = new StringBuilder().append(generatedNumber).append(generatedLetter).toString();
        return generatedId;
    }

    private boolean isIdAvailable(String id) {
        var result = mongoDBConnection.getDatabaseConnection("players")
                .getCollection("players_personal_ids")
                .find(eq("player_id", id)).first();
        return result.getBoolean("available");
    }
}
