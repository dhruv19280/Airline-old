package Airline.src.model;

public class AirlineGame {

    public static void Initialize() {

        System.out.println("Initializing Airports...");
        AirportsInitializer.InitializeAll();
        //AirportsInitializer.PrintAllAirports();
        System.out.println("Airports Initialization Completed.");

        System.out.println("Initializing Aircrafts...");
        AircraftModelsInitializer.InitializeAll();
        AircraftModelsInitializer.PrintAllAircraftModels();
        System.out.println("Aircrafts Initialization Completed.");

        System.out.println("Initializing Airlines...");
        AirlineInitializer.InitializeAll();
        AirlineInitializer.PrintAllAirlines();
        System.out.println("Airlines Initialization Completed.");

        System.out.println("Initializing GameTime...");
        GameTime gtGameTime = new GameTime();
        Thread thGameTime = new Thread(gtGameTime);
        thGameTime.start();
        System.out.println("GameTime Initialized and Running.");
    }
}