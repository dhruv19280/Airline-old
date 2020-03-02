package Airline.src.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AircraftModelsInitializer {

    private static final String sParentURL = "https://www.aircraftcompare.com/manufacturer-categories/airplane/";

    public static List<AircraftModel> lstAllAircraftModels;


    public static void InitializeAll() {

        lstAllAircraftModels = new ArrayList<AircraftModel>();
        ParseParentURL(sParentURL);

        System.out.println(lstAllAircraftModels.size() + ": Size of AircraftModels");
    }

    private static void ParseParentURL(String sURL) {

        Document doc = null;

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("ul.list-manufacturers a");

            int i = 0;
            for (Element row : tablerows) {

                try {
                    String sManufacturerURL = row.attr("href");
                    String sManufacturerName = row.text();
                    //System.out.println("Processing : " + sManufacturerName + " : " + sManufacturerURL);
                    ParseManufacturerURL(sManufacturerName, sManufacturerURL);
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ParseManufacturerURL(String sManufacturerName, String sManufacturerURL) {
        Document doc = null;

        try {
            doc = Jsoup.connect(sManufacturerURL).get();
            Elements tablerows = doc.select("section.mb-4.px-3");

            for (Element row : tablerows) {

                try {
                    String sModelCategory = row.select("h3").text();
                    Elements subrows = tablerows.select("div.media-body");

                    for (Element subrow : subrows) {
                        String sModelURL = subrow.select("a").attr("href");
                        String sModelName = subrow.select("a").text();
                        String sModelPrice = subrow.select("p").text();
                        System.out.println("Processing : " + sManufacturerName + " : " + sModelCategory + " : " + sModelName + " : " + sModelPrice + " : " + sModelURL);
                        if(
                                sModelCategory.equalsIgnoreCase("Passenger Turbo Props")
                                || sModelCategory.equalsIgnoreCase("Light Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Mid Size Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Jumbo Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Cargo Airplanes")
                        ) {
                            ParseModelURL(sModelURL, sManufacturerName, sModelCategory, sModelName, sModelPrice);
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ParseModelURL(String sURL, String sMfr, String sCategory, String sModel, String sPrice) {
        Document doc = null;

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("dl.row.mb-0");

            String sAvionics = "";
            String sEngine = "";
            String sPower = "";
            String sSpeed = "";
            String sRange = "";
            String sFuelEconomy = "";
            String sTakeOffDistance = "";
            String sLandingDistance = "";
            String sPayload = "";
            String sTankCapacity = "";
            String sSeatsEconomy = "";
            String sSeatsBusiness = "";
            String sSeatsFirst = "";
            String sWingSpan = "";

            for (Element row : tablerows) {
                Elements headers = row.select("dt");
                Elements values = row.select("dd");

                for (int i = 0; i < headers.size(); i++) {
                    try {

                        if (headers.get(i).text().contains("Avionics")) sAvionics = values.get(i).text();
                        if (headers.get(i).text().contains("Engine")) sEngine = values.get(i).text();
                        if (headers.get(i).text().contains("Power")) sPower = values.get(i).text();
                        if (headers.get(i).text().contains("Cruise Speed")) sSpeed = values.get(i).text();
                        if (headers.get(i).text().contains("range")) sRange = values.get(i).text();
                        if (headers.get(i).text().contains("Fuel Economy")) sFuelEconomy = values.get(i).text();
                        if (headers.get(i).text().contains("Take Off Distance")) sTakeOffDistance = values.get(i).text();
                        if (headers.get(i).text().contains("Landing Distance")) sLandingDistance = values.get(i).text();
                        if (headers.get(i).text().contains("Payload")) sPayload = values.get(i).text();
                        if (headers.get(i).text().contains("Tank Capacity")) sTankCapacity = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - Economy")) sSeatsEconomy = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - Business")) sSeatsBusiness = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - First")) sSeatsFirst = values.get(i).text();
                        if (headers.get(i).text().contains("Wing Span")) sWingSpan = values.get(i).text();
                        System.out.println("Processing : " + headers.get(i).text() + " : " + values.get(i).text());

                    } catch (Exception e) {
                        continue;
                    }

                }
            }

            //Create Aircraft Object and Append to List.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void PrintAllAircraftModels() {
        for (AircraftModel a : lstAllAircraftModels) {
            a.PrintDetails();
        }
    }

}
