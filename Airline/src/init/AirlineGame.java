package Airline.src.init;

import Airline.src.init.AircraftModelsInitializer;
import Airline.src.init.AirlineInitializer;
import Airline.src.init.AirportsInitializer;
import Airline.src.model.Airline;
import Airline.src.model.GameTime;

public class AirlineGame {

    public static void Initialize() {

        InitializeAirports();

        InitializeAirlines();

        InitializeAircraftModels();

        InitializeGameTime();

    }

    private static void InitializeAirports() {
        System.out.println("Initializing Airports...");
        AirportsUpdater.Update();
        //AirportsInitializer.InitializeAll();
        //AirportsInitializer.PrintAllAirports();
        System.out.println("Airports Initialization Completed.");
    }

    private static void InitializeAirlines() {

        System.out.println("Initializing Airlines...");
        AirlineInitializer.InitializeAll();
        //AirlineInitializer.PrintAllAirlines();
        System.out.println("Airlines Initialization Completed.");
    }

    private static void InitializeAircraftModels() {

        System.out.println("Initializing Aircraft Models...");
        AircraftModelsInitializer.InitializeAll();
        AircraftModelsInitializer.PrintAllAircraftModels();
        System.out.println("Aircraft Model Initialization Completed.");
    }

    private static void InitializeGameTime() {

        System.out.println("Initializing GameTime...");
        GameTime gtGameTime = new GameTime();
        Thread thGameTime = new Thread(gtGameTime);
        thGameTime.start();
        System.out.println("GameTime Initialized and Running.");
    }
}