package Airline.src.init;

import Airline.src.model.Airport;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AirportsUpdater {

    public static List<Airport> lstAllAirports;

    public static void InitializeAll() {

        lstAllAirports = new ArrayList<Airport>();

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

        String[] parts = response.body().split("<a class=\"hometoplist-item\" href=\"/");
        int i = 0;

        while(i < parts.length) {
            if (i > 0) {
                String sAirportCode = "";
                sAirportCode = parts[i].substring(0, 3);
                String[] parts1;
                String sFlights = "";
                parts1 = parts[i].split("<span class=\"makebluehighlight\">");
                sFlights = parts1[1].substring(0,3);
                //System.out.println(sAirportCode +  " - " + sFlights +  " Flights");
                Airport a = new Airport(sAirportCode, Integer.parseInt(sFlights));
                lstAllAirports.add(a);
            }
            i++;
        }

    }
}


/*


                    <a class="hometoplist-item" href="/MAA">

                        <div class="hometoplist-counter">63</div>

                        <div class="hometoplist-content">

                            <span class="hometoplist-first">Madras   (MAA)</span>

                            <span class="hometoplist-last"><span class="makebluehighlight">200 flights</span> every day</span>

                        </div>
                         <div class="hometoplist-logos"><div class="hometoplist-logo-wrapper"><img src="/img/flags/IN.png.pagespeed.ce.N-SvM36nqV.png" class="hometoplist-logo"></div></div>
                    </a>


 */