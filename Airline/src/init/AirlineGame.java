package Airline.src.init;

import Airline.src.model.Aircraft;
import Airline.src.model.Airline;
import Airline.src.model.GameTime;

import java.io.FileNotFoundException;
import java.util.Random;

public class AirlineGame {

    public static Airline thisAirline;

    public static void Initialize() {

        try {
            InitializeAirports();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InitializeAirlines();
        InitializeAircraftModels();
        InitializeGameTime();

        SetThisAirline();
        ProvideInitialAircraft();

    }

    private static void ProvideInitialAircraft() {
        Aircraft a = new Aircraft("Aircraft 1","Boeing", "Boeing 747-300");
        thisAirline.PurchaseAircraft(a, 0D);
    }

    private static void InitializeAirports() throws FileNotFoundException {
        System.out.println("Initializing Airports...");
        AirportsUpdater.InitializeAll();
        System.out.println("Airports Initialization Completed.");
    }

    private static void SetThisAirline() {
        Random r = new Random();
        thisAirline = AirlineInitializer.lstAllAirlines.get(r.nextInt(AirlineInitializer.lstAllAirlines.size()));
    }

    private static void InitializeAirlines() {

        System.out.println("Initializing Airlines...");
        AirlineInitializer.InitializeAll();
        System.out.println("Airlines Initialization Completed.");
    }

    private static void InitializeAircraftModels() {

        System.out.println("Initializing Aircraft Models...");
        AircraftModelsInitializer.InitializeAll();
        //AircraftModelsInitializer.PrintAllAircraftModels();
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