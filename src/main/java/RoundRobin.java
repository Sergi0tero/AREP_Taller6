import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static spark.Spark.*;

public class RoundRobin {
    public static String randomizePort(String url, String path){
        int consultPort = (int) (Math.random() * (3)) + 34001;
        return url + consultPort + path;
    }
    public static void main(String[] args) {
        staticFileLocation("/");
        port(getPort());
        get("/logs", (request, response) -> {
            URL url = new URL(randomizePort("http://localhost:", "/logs"));
            //"http://172.31.60.208:" "ec2-100-24-74-94.compute-1.amazonaws.com:"
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            String responseBody = "";

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNext()) {
                    responseBody += scanner.nextLine();
                }
                scanner.close();
            }
            conn.disconnect();
            return responseBody;
        });
        post("/logs", (request, response) -> {
            URL url = new URL(randomizePort("http://localhost:", "/logs"));
            //"http://172.31.60.208:" "ec2-100-24-74-94.compute-1.amazonaws.com:"
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/plain");

            String requestBody = request.body();
            byte[] postData = requestBody.getBytes("UTF-8");
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(postData);
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responseBody = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine);
            }
            in.close();

            con.disconnect();

            return responseBody.toString();
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
