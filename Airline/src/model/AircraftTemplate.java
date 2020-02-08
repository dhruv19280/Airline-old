package Airline.src.model;

public interface AircraftTemplate{

    public String sAircraftTail="";
    public String sAircraftNick="";
    public String sManufacturer="";
    public String sModel="";

    public Integer iFuelCapacity=0;
    public Integer iRemainingFuel=0;

    public Integer iMaximumRange=0;
    public Integer iCurrentRange=0;

    public Double dMilesPerGallon=0.00D;

    public Integer iEconomyPassengerCapacity=0;
    public Integer iBusinessPassengerCapacity=0;
    public Integer iFirstPassengerCapacity=0;
    public Integer iCargoCapacity=0;

    public Boolean bSold=false;
    public Integer iPurchasedYear=1950;
    public Integer iAge=0;
    public Boolean bInFlight=false;

    public Double dWearTearPercentage=0.00D;

    public void BoardPassengers();
    public void DeboardPassengers();
    public void BoardCargo();
    public void DeboardCargo();
    public void Fly();
    public void PerformMaintenance();
    public void TakeOff();
    public void Land();
}