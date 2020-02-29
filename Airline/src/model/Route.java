package Airline.src.model;

public class Route {

    private Airport aSource;
    private Airport aTarget;

    private Integer iDistance;

    private Integer iEcoPassengersAtSource;
    private Integer iBusPassengersAtSource;
    private Integer iFirstPassengersAtSource;
    private Integer iCargoAtSource;


    private Integer iEcoPassengersAtTarget;
    private Integer iBusPassengersAtTarget;
    private Integer iFirstPassengersAtTarget;
    private Integer iCargoAtTarget;

    private Double dEcoPassengerGenerationAtSource;
    private Double dBusPassengerGenerationAtSource;
    private Double dFirstPassengerGenerationAtSource;
    private Double dCargoGenerationAtSource;

    private Double dEcoPassengerGenerationAtTarget;
    private Double dBusPassengerGenerationAtTarget;
    private Double dFirstPassengerGenerationAtTarget;
    private Double dCargoGenerationAtTarget;

    private Double dRouteGrossSetupCost;
    private Double dRouteSubsidies;
    private Double dRouteNetSetupCost;

    private Double dRouteCostPerFlight;



    public void GeneratePassengers() {

    }

    public void DeliverPassengers() {

    }

    public void GenerateCargo() {

    }

    public void DeliverCargo() {

    }
}