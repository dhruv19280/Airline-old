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
                        ParseModelURL(sModelURL, sManufacturerName, sModelCategory, sModelName, sModelPrice);
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
        List<String, String> sProperties = new ArrayList<String, String>();

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("dl.row.mb-0");

            for (Element row : tablerows) {
                Elements headers = row.select("dt");
                Elements values = row.select("dd");


                for (int i = 0; i < headers.size(); i++) {
                    try {
                        System.out.println("Processing : ");
                    } catch (Exception e) {
                        continue;
                    }

                }
            }
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
