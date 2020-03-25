package Airline.src.init;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import Airline.src.model.Airline;
import Airline.src.model.Airport;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AirportsInitializer {

    private static final String sURLAfrica = "https://www.flightsfrom.com/top-100-airports-in-africa";
    private static final String sURLAsia = "https://www.flightsfrom.com/top-100-airports-in-asia";
    private static final String sURLEurope = "https://www.flightsfrom.com/top-100-airports-in-europe";
    private static final String sURLNAmerica = "https://www.flightsfrom.com/top-100-airports-in-north-america";
    private static final String sURLSAmerica = "https://www.flightsfrom.com/top-100-airports-in-south-america";
    private static final String sURLOceania = "https://www.flightsfrom.com/top-100-airports-in-oceania";

    public static List<Airport> lstAllAirports;

    public static void InitializeAll() {



        lstAllAirports = new ArrayList<Airport>();

        lstAllAirports.addAll(ParseURLintoAirports(sURLAfrica));
        lstAllAirports.addAll(ParseURLintoAirports(sURLAsia));
        lstAllAirports.addAll(ParseURLintoAirports(sURLEurope));
        lstAllAirports.addAll(ParseURLintoAirports(sURLOceania));
        lstAllAirports.addAll(ParseURLintoAirports(sURLNAmerica));
        lstAllAirports.addAll(ParseURLintoAirports(sURLSAmerica));

        System.out.println(lstAllAirports.size() + ": Size of All Airports Before Cleanup");

        CleanUpAirports();

        System.out.println(lstAllAirports.size() + ": Size of All Airports After Cleanup");

    }

    private static List<Airport> ParseURLintoAirports(String sURL) {

        Document doc = null;
        ArrayList<Airport> lstAirports = new ArrayList<Airport>();

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("a.hometoplist-item");

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

        return lstAirports;
    }

    public static void PrintAllAirports() {
        for (Airport a : lstAllAirports) {
            a.PrintDetails();
        }
    }

    private static void CleanUpAirports() {

        for(int i = 0; i<lstAllAirports.size(); i++){
            //System.out.println(myList.get(i));
            if(!lstAllAirports.get(i).IsValid()){
                lstAllAirports.remove(i);
                i--;
            }
        }
    }
}


/*
https://www.flightsfrom.com/top-100-airlines


https://www.flightsfrom.com/top-100-international-routes
https://www.flightsfrom.com/top-100-intercontinental-routes
https://www.flightsfrom.com/top-100-domestic-routes

 */