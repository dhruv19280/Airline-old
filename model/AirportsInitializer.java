package Airline.model;

import java.io.BufferedReader;
import java.util.List;

public class AirportsInitializer {

    private String sURLAfrica;
    private String sURLAsia;
    private String sURLEurope;
    private String sURLNAmerica;
    private String sURLSAmerica;
    private String sURLOceania;

    AirportsInitializer() {
        sURLAfrica="https://www.flightsfrom.com/top-100-airports-in-africa";
        sURLAsia="https://www.flightsfrom.com/top-100-airports-in-asia";
        sURLEurope="https://www.flightsfrom.com/top-100-airports-in-europe";
        sURLNAmerica="https://www.flightsfrom.com/top-100-airports-in-north-america";
        sURLSAmerica="https://www.flightsfrom.com/top-100-airports-in-south-america";
        sURLOceania="https://www.flightsfrom.com/top-100-airports-in-oceania";
    }

    public static List<Airport> InitializeAll() {

        String resultAfrica = getUrlContents(sURLAfrica);
        String resultAsia = getUrlContents(sURLAsia);
        String resultEurope = getUrlContents(sURLEurope);
        String resultNAmerica = getUrlContents(sURLNAmerica);
        String resultSAmerica = getUrlContents(sURLSAmerica;
        String resultOceania = getUrlContents(sURLOceania);
    }

    private static String getUrlContents(String theUrl)
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

}

/*
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