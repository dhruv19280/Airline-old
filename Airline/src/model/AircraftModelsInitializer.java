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
        ArrayList<AircraftModel> lstAirports = new ArrayList<AircraftModel>();

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("ul.list-manufacturers a");

            int i = 0;
            for (Element row : tablerows) {

                try {
                    String sManufacturerURL=row.attr("href");
                    String sManufacturerName = row.text();
                    System.out.println(sManufacturerName + " : " + sManufacturerURL);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lstAllAircraftModels;
    }

    private static void ProcessManufacturerURL(String sManufacturerName, String sManufacturerURL) {

    }

    public static void PrintAllAircraftModels() {
        for (AircraftModel a : lstAllAircraftModels) {
            a.PrintDetails();
        }
    }

}
