
import java.time.Instant;
import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    static ArrayList<String> logs = new ArrayList<>();
    public static void main(String... args) {
        staticFileLocation("/");
        port(getPort());
        postLog();
        getlogs();
    }

    public static void getlogs(){
        get("logs", (req,res) -> {
            ArrayList<String> shownLogs = new ArrayList<>();
            int limit = Math.min(logs.size(), 10);
            for (int i = 0 ; i < limit ; i++){
                shownLogs.add(logs.get(i));
            }
            return shownLogs.toString();
        });
    }

    public static void postLog(){
        post("logs", (req,res) -> {
            logs.add(req.body() + Instant.now());
            return req.body() + Instant.now();
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
