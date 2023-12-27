package com.glipe.nakedappserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glipe.nakedappserver.MongoDBConnection;
import com.glipe.nakedappserver.model.PlayerInfo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class PlayerInfoService {


    @Value("${random.available.letters}")
    public final List<String> availableLetters;

    private final MongoDBConnection mongoDBConnection;

    private final ObjectMapper objectMapper;


    public PlayerInfo createPlayerInfo(PlayerInfo playerInfo) throws JsonProcessingException {
        MongoCollection<Document> collection = mongoDBConnection.getDatabaseConnection("test_db").getCollection("test_collection");

        String generatedID = randomPlayerID();
        playerInfo.setPlayerID(generatedID);

        Document document = Document.parse(objectMapper.writeValueAsString(playerInfo));

        InsertOneResult insertResult = collection.insertOne(document);

        if (insertResult.getInsertedId().asString().getValue().isEmpty()){
           throw new RuntimeException();
        }
        return playerInfo;


    }

    private String randomPlayerID(){

        var generatedId =  generateNumberLetter();
        while(isIdExistent(generatedId)){
            generatedId = generateNumberLetter();
        }

        return generatedId;

    }
    private String generateNumberLetter(){
        Random random = new Random();
        var alphabetIndex = random.nextInt(0,25);
        var generatedNumber = random.nextInt(0,9);
        String generatedLetter = availableLetters.get(alphabetIndex);

        var generatedId =  new StringBuilder().append(generatedNumber).append(generatedLetter).toString();
        return generatedId;
    }



    private boolean isIdExistent(String id){
        return false;
    }

}
