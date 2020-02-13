package Airline.src.model;

public interface AircraftTemplate{

    public String sAircraftTail="";
    public String sAircraftNick="";
    public String sManufacturer="";
    public String sModel="";

    public Integer iFuelCapacity=0;
    public Integer iRemainingFuel=0;
    public Double dConsumptionLitersPerPaxPerHundredKM=0.00D;

    public Integer iCompleteFlights = 0;
    public Integer iCompleteFlightHours = 0;

    public Integer iMaximumRange=0;
    public Integer iCurrentRange=0;
    public Integer iSpeedPerHour=0;

    public Integer iEconomyPassengerCapacity=0;
    public Integer iBusinessPassengerCapacity=0;
    public Integer iFirstPassengerCapacity=0;
    public Integer iCargoCapacity=0;

    public Boolean bSold=false;
    public Integer iPurchasedYear=1950;
    public Integer iAge=0;
    public Boolean bInFlight=false;

    public Double dWearRatePerHundredHour = 0.00D;
    public Double dCurrentWearPercentage=0.00D;


    public Double dPurchasePrice = 0.00D;
    public Double dRegularMaintenanceCost=0.00D;
    public Double dCumulativeMaintenanceCosts=0.00D;
    public Double dCumulativeFuelCosts=0.00D;
    public Double dCumulativePassengerRevenue=0.00D;
    public Double dCumulativeCargoRevenue=0.00D;
    public Double dCumulativeOtherRevenue=0.00D;

    public Float dCumulativeProfitability=0.00F;

    public void BoardPassengers();
    public void DeboardPassengers();
    public void BoardCargo();
    public void DeboardCargo();
    public void Fly();
    public void BreakDown();
    public void PerformMaintenance();
    public void TakeOff();
    public void Land();
}