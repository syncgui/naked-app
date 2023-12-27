package com.glipe.nakedappserver;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.eq;


@Component
public class MongoDBConnection {

    @Value("${mongodb.connection.uri}")
    private String mongoDBuri;

    MongoClient mongoClient;


    public MongoDatabase getDatabaseConnection(String databaseName) {
        mongoClient = MongoClients.create(mongoDBuri);
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        return database;
    }

    public MongoClientSettings mongoClientSettings() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoDBuri))
                .serverApi(serverApi)
                .build();
    }


    public void closeConnection() {
        mongoClient.close();
    }

}
