package Airline.src.model;

public class AirlineGame {

    public static void Initialize() {

        GameTime gtGameTime = new GameTime();
        Thread thGameTime = new Thread(gtGameTime);
        thGameTime.start();


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