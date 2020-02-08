package Airline.src.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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

    public static void InitializeAll1() {

        sURLAfrica="https://www.flightsfrom.com/top-100-airports-in-africa";
        sURLAsia="https://www.flightsfrom.com/top-100-airports-in-asia";
        sURLEurope="https://www.flightsfrom.com/top-100-airports-in-europe";
        sURLNAmerica="https://www.flightsfrom.com/top-100-airports-in-north-america";
        sURLSAmerica="https://www.flightsfrom.com/top-100-airports-in-south-america";
        sURLOceania="https://www.flightsfrom.com/top-100-airports-in-oceania";

        String resultAfrica = GetUrlContents(sURLAfrica);
        String resultAsia = GetUrlContents(sURLAsia);
        String resultEurope = GetUrlContents(sURLEurope);
        String resultNAmerica = GetUrlContents(sURLNAmerica);
        String resultSAmerica = GetUrlContents(sURLSAmerica);
        String resultOceania = GetUrlContents(sURLOceania);

        BuildAirportsFromString(resultAfrica);
        BuildAirportsFromString(resultAsia);
        BuildAirportsFromString(resultEurope);
        BuildAirportsFromString(resultNAmerica);
        BuildAirportsFromString(resultOceania);
        BuildAirportsFromString(resultSAmerica);
    }

    private static String GetUrlContents(String theUrl)
    {
      StringBuilder content = new StringBuilder();
      try
      {
        URL url = new URL(theUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
  
        String line;
        while ((line = bufferedReader.readLine()) != null)
        {
          content.append(line + "\n");
        }
        bufferedReader.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      return content.toString();
    }

    private static void BuildAirportsFromString(String sInput) {

      String sToken = "";
      String sTemp = "";
      String sAirportName = "";
      String sAirportICAO = "";
      String sAirportCity = "";
      Integer iFlights = 0 ;


      if (!sInput.isBlank() || !sInput.isEmpty()) {

        StringTokenizer stk = new StringTokenizer(sInput, "<div class=\"hometoplist-content\">");
        while (stk.hasMoreTokens()) {
          sToken = "";
          sTemp = "";
          sAirportName = "";
          sAirportICAO = "";
          iFlights = 0;

          sToken = stk.nextToken();
          StringTokenizer stk1 = new StringTokenizer(sToken, "<span class=");

          sAirportName = stk1.nextToken();
          sAirportName = sAirportName.substring(sAirportName.indexOf(">"), sAirportName.indexOf("<"));

          sAirportICAO = sAirportName.substring(sAirportName.indexOf("("), sAirportName.indexOf(")"));
          sAirportCity = sAirportName.substring(0, sAirportName.indexOf("  "));

          sTemp = stk1.nextToken();
          sTemp = stk1.nextToken();

          sTemp = sTemp.substring(sTemp.indexOf(">"), sTemp.indexOf(" "));
          iFlights = Integer.parseInt(sTemp);



          Airport aTemp = new Airport(sAirportName, sAirportICAO, ""/*Determine Country from City? */, sAirportCity, iFlights);
          lstAllAirports.add(aTemp);
        }
      }
      
    } 

    public void initializeAll() {
      Document doc = Jsoup.connect(sURLAfrica).get();
      String title = doc.title();
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






<div class="hometoplist-content">
  <span class="hometoplist-first">Chicago   (ORD)</span>
  <span class="hometoplist-last"><span class="makebluehighlight">
  982 flights</span> every day</span>
</div>
*/