
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.time.Instant;
import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    private static MongoClient client = null;
    private static String url = "172.31.60.208:27017";
    private static MongoDatabase db = null;
    private static MongoCollection<Document> collec;

    public static void createConnection(){
        client = new MongoClient(url);
        db = client.getDatabase("admin");
        collec = db.getCollection("basePrueba");
    }
    public static void main(String... args) {
        createConnection();
        port(getPort());
        postLog();
        getlogs();
    }

    public static void getlogs(){
        get("logs", (req,res) -> {
            ArrayList<String> shownLogs = new ArrayList<>();
            for (Document d : collec.find()){
                shownLogs.add(d.toJson());
            }
            return shownLogs;
        });
    }

    public static void postLog(){
        post("logs", (req,res) -> {
            Document newDoc = new Document("body", req.body());
            newDoc.put("date", Instant.now());
            collec.insertOne(newDoc);
            return req.body() + Instant.now();
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4088;
    }
}
