package Airline.model;

public class Flight {

    private String sFlightCode;
    //Departure and Arrival Times?
    private Airline aAirline;
    private Airport aSource;
    private Airport aTarget;
    private Aircraft aAircraft;
    

    private Integer iEconomyPassengers;
    private Integer iBusinessPassengers;
    private Integer iFirstPassengers;
    private Integer iCargo;
    
    private Double dEconomyIncome;
    private Double dBusinessIncome;
    private Double dFirstIncome;
    private Double dCargoIncome;

    private Double dFuelCost;
    private Double dPilotCost;
    private Double dCrewCost;
    private Double dGateCost;
    private Double dOtherCost;

    private Double dTotalIncome;
    private Double dTotalExpenses;
    
    private Double dProfitOrLoss;
}