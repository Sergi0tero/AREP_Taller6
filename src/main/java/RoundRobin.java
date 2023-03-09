import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static spark.Spark.get;
import static spark.Spark.port;

public class RoundRobin {
    public static void main(String[] args) {
        port(getPort());
        get("/prueba", (request, response) -> {
            System.out.println("entro");
            URL url = new URL("http://localhost:4088/logs");
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
                System.out.println(responseBody);
                scanner.close();
            }

            conn.disconnect();
            return "";
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
