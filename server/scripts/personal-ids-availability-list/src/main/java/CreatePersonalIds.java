import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class CreatePersonalIds {

    public static void main(String[] args) {

        MongoDBConnection mongoDBConnection = new MongoDBConnection();
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Map<String, Object> map = new HashMap<>();

        var collection = mongoDBConnection.getDatabaseConnection("players")
                .getCollection("players_personal_ids");

        for (String l : alphabet) {
            for (int n : numbers) {

                String playerId = new StringBuilder()
                        .append(n).append(l).toString();

                map.put("player_id", playerId);
                map.put("available", true);

                collection.insertOne(new Document(map));
            }
        }
    }
}
