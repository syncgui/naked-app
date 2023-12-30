import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private final String mongoDBuri = "mongodb+srv://naked_app_user:c1yRrHMaVww6pnmH@cluster0.e3ixbgt.mongodb.net/?retryWrites=true&w=majority";

    MongoClient mongoClient;


    public MongoDatabase getDatabaseConnection(String databaseName) {
        mongoClient = MongoClients.create(mongoDBuri);
        return mongoClient.getDatabase(databaseName);
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