package Airline.src.init;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class AirportsUpdater {

    public static void Update() {
        String sURL = "https://www.flightsfrom.com/top-100-airports";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(sURL))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(response.body());
    }

}
