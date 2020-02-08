package Airline.src.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AirportsInitializer {

    private static String sURLAfrica = "";
    private static String sURLAsia = "";
    private static String sURLEurope = "";
    private static String sURLNAmerica = "";
    private static String sURLSAmerica = "";
    private static String sURLOceania = "";

    public static List<Airport> lstAllAirports;

    public static void InitializeAll() {

        lstAllAirports = new ArrayList<Airport>();

        sURLAfrica="https://www.flightsfrom.com/top-100-airports-in-africa";
        sURLAsia="https://www.flightsfrom.com/top-100-airports-in-asia";
        sURLEurope="https://www.flightsfrom.com/top-100-airports-in-europe";
        sURLNAmerica="https://www.flightsfrom.com/top-100-airports-in-north-america";
        sURLSAmerica="https://www.flightsfrom.com/top-100-airports-in-south-america";
        sURLOceania="https://www.flightsfrom.com/top-100-airports-in-oceania";

        lstAllAirports.addAll(ParseURLintoAirports(sURLAfrica));
        lstAllAirports.addAll(ParseURLintoAirports(sURLAsia));
        lstAllAirports.addAll(ParseURLintoAirports(sURLEurope));
        lstAllAirports.addAll(ParseURLintoAirports(sURLOceania));
        lstAllAirports.addAll(ParseURLintoAirports(sURLNAmerica));
        lstAllAirports.addAll(ParseURLintoAirports(sURLSAmerica));

        System.out.println(lstAllAirports.size() + ": Size of All Airports");
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
                    System.out.println(temp);
                    StringTokenizer stk = new StringTokenizer(temp, " ");

                    stk.nextToken();

                    String sCity = stk.nextToken();
                    String bracket = stk.nextToken();

                    while (bracket.indexOf("(") < 0) {
                        sCity = sCity.concat(" " + bracket);
                        bracket = stk.nextToken();
                    }
                    String sICAO = bracket.substring(1,4);
                    String sFlights = stk.nextToken();

                    lstAirports.add(new Airport(sCity, sICAO, sCity, sCity, Integer.parseInt(sFlights)));
                    i++;

                } catch (Exception e) {
                    continue;
                }

            }
            System.out.println(i + " Airports Parsed");
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





}


/*
String sName, String sICAO, String sCountry, String sCity, Integer iFlights



https://www.flightsfrom.com/top-100-airports-in-africa
https://www.flightsfrom.com/top-100-airports-in-asia
https://www.flightsfrom.com/top-100-airports-in-europe
https://www.flightsfrom.com/top-100-airports-in-north-america
https://www.flightsfrom.com/top-100-airports-in-oceania
https://www.flightsfrom.com/top-100-airports-in-south-america


https://www.flightsfrom.com/top-100-airlines


https://www.flightsfrom.com/top-100-international-routes
https://www.flightsfrom.com/top-100-intercontinental-routes
https://www.flightsfrom.com/top-100-domestic-routes

 */