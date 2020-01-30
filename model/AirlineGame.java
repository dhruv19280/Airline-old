package Airline.model;

import java.util.List;

public class AirlineGame {

    private static List<Airport> lstAllAirports;

    public static void Initialize() {
        lstAllAirports = AirportsInitializer.InitializeAll();

        
        /*
        AirlinesInitializer.InitializeAll();
        GameGenerator.InitializeAll();
        CrewInitializer.InitializeAll();
        RouteInitializer.InitializeAll();
        */
    }
}