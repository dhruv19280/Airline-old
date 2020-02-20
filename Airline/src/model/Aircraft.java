package Airline.src.model;

public class Aircraft extends AircraftModel implements AircraftTemplate {

    private String sAircraftTail="";
    private String sAircraftNick="";
    private String sManufacturer="";
    private String sModel="";

    private Integer iFuelCapacity=0;
    private Integer iRemainingFuel=0;
    private Double dConsumptionLitersPerPaxPerHundredKM=0.00D;

    private Integer iCompleteFlights = 0;
    private Integer iCompleteFlightHours = 0;

    private Integer iMaximumRange=0;
    private Integer iCurrentRange=0;
    private Integer iSpeedPerHour=0;

    private Integer iEconomyPassengerCapacity=0;
    private Integer iBusinessPassengerCapacity=0;
    private Integer iFirstPassengerCapacity=0;
    private Integer iCargoCapacity=0;

    private Boolean bSold=false;
    private Integer iPurchasedYear=1950;
    private Integer iAge=0;
    private Boolean bInFlight=false;

    private Double dWearRatePerHundredHour = 0.00D;
    private Double dCurrentWearPercentage=0.00D;


    private Double dPurchasePrice = 0.00D;
    private Double dRegularMaintenanceCost=0.00D;
    private Double dCumulativeMaintenanceCosts=0.00D;
    private Double dCumulativeFuelCosts=0.00D;
    private Double dCumulativePassengerRevenue=0.00D;
    private Double dCumulativeCargoRevenue=0.00D;
    private Double dCumulativeOtherRevenue=0.00D;

    private Float dCumulativeProfitability=0.00F;

    @Override
    public void BoardPassengers() {

    }

    @Override
    public void DeboardPassengers() {

    }

    @Override
    public void BoardCargo() {

    }

    @Override
    public void DeboardCargo() {

    }

    @Override
    public void Fly() {

    }

    @Override
    public void BreakDown() {

    }

    @Override
    public void PerformMaintenance() {

    }

    @Override
    public void TakeOff() {

    }

    @Override
    public void Land() {

    }
}