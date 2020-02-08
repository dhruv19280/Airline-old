package Airline.src.model;

public class AirlineGame {

    public static void Initialize() {
        AirportsInitializer.InitializeAll();
        AirportsInitializer.PrintAllAirports();

        
        /*
        AirlinesInitializer.InitializeAll();
        GameGenerator.InitializeAll();
        CrewInitializer.InitializeAll();
        RouteInitializer.InitializeAll();
        */
    }
}