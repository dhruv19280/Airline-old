package Airline.src.init;

import Airline.src.model.Airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FlightsFrom {
    public String sIATA;
    public String sFlights;

    public FlightsFrom(String sIC, String sF) {
        this.sIATA = sIC;
        this.sFlights = sF;
    }
}

public class AirportsUpdater {

    public static List<Airport> lstAllAirports;
    private static List<FlightsFrom> lstFlightsFrom;

    public static void ReadWebForSizing() {

        String sURL = "https://www.flightsfrom.com/top-100-airports";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(sURL))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] parts = response.body().split("<a class=\"hometoplist-item\" href=\"/");
        int i = 0;
        lstFlightsFrom = new ArrayList<FlightsFrom>();

        while(i < parts.length) {
            if (i > 0) {
                String sAirportCode, sFlights;
                String[] parts1;
                sAirportCode = parts[i].substring(0, 3);
                parts1 = parts[i].split("<span class=\"makebluehighlight\">");
                sFlights = parts1[1].substring(0,3);
                lstFlightsFrom.add(new FlightsFrom(sAirportCode, sFlights));
            }
            i++;
        }

    }

    public static void InitializeAll() throws FileNotFoundException {

        String sInputFile = "airports.csv";
        String DEFAULT_SEPARATOR = ",";

        ReadWebForSizing();
        lstAllAirports = new ArrayList<Airport>();

        Scanner scanner = new Scanner(new File(sInputFile));
        String line = scanner.nextLine();

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            String sIATA, sFlights="";
            String[] values = line.split(DEFAULT_SEPARATOR);
            boolean found = false;
            sIATA = values[0];

            Airport a = new Airport(sIATA);

            if(values.length > 8) {
                a.UpdateInitialize(values[2], values[7], values[8], values[3], values[4], values[5]);
            } else {
                a.UpdateInitialize(values[2], values[7], "", values[3], values[4], values[5]);
            }


            for (FlightsFrom flightsFrom : lstFlightsFrom) {
                if (flightsFrom.sIATA.equalsIgnoreCase(sIATA)) {
                    sFlights = flightsFrom.sFlights;
                    found = true;
                }
            }
            if(found) {
                a.DeriveOtherFields(Integer.parseInt(sFlights));
            } else
            {
                a.DeriveOtherFields(0);
            }

            lstAllAirports.add(a);
        }

        scanner.close();
        System.out.println("Size of Airports Before Cleanup: " + lstAllAirports.size());

        CleanUpAirports();

        System.out.println("Size of Airports After Cleanup: " + lstAllAirports.size());

    }

    public static void CleanUpAirports() {
        for (int i = 0; i < lstAllAirports.size(); i++) {
            if(!lstAllAirports.get(i).IsValid()) {
                lstAllAirports.remove(i);
                i--;
            }
        }
    }
}