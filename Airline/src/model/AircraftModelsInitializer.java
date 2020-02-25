package Airline.src.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AircraftModelsInitializer {

    private static final String sURLManufacturers = "https://www.aircraftcompare.com/manufacturer-categories/airplane/";

    public static List<AircraftModel> lstAllAircraftModels;
    private static List<String> lstModelsURLs;


    public static void InitializeAll() {

        lstAllAircraftModels = new ArrayList<AircraftModel>();
        lstAllAircraftModels.addAll(ParseManufacturerURL(sURLManufacturers));

        System.out.println(lstAllAircraftModels.size() + ": Size of All Manufacturers");
    }

    private static List<AircraftModel> ParseManufacturerURL(String sURL) {

        Document doc = null;
        ArrayList<Airport> lstAirports = new ArrayList<Airport>();

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("div.col-9");

            int i = 0;
            for (Element row : tablerows) {

                try {
                    String temp = row.text();
                    StringTokenizer stk = new StringTokenizer(temp, " ");

                    stk.nextToken();

                    String sCity = stk.nextToken();
                    String bracket = stk.nextToken();

                    while (bracket.indexOf("(") < 0) {
                        sCity = sCity.concat(" " + bracket);
                        bracket = stk.nextToken();
                    }
                    String sICAO = bracket.substring(1, 4);
                    String sFlights = stk.nextToken();

                    lstAirports.add(new Airport(sICAO, Integer.parseInt(sFlights)));
                    i++;

                } catch (Exception e) {
                    continue;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lstAllAircraftModels;
    }

    public static void PrintAllAircraftModels() {
        for (AircraftModel a : lstAllAircraftModels) {
            a.PrintDetails();
        }
    }

}
