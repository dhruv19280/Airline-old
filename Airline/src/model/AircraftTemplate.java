package Airline.src.model;

public interface AircraftTemplate{

    public String sAircraftTail;
    public String sAircraftNick;
    public String sManufacturer;
    public String sModel;

    public Integer iFuelCapacity;
    public Integer iRemainingFuel;

    public Integer iMaximumRange;
    public Integer iCurrentRange;

    public Double dMilesPerGallon;

    public Integer iEconomyPassengerCapacity;
    public Integer iBusinessPassengerCapacity;
    public Integer iFirstPassengerCapacity;
    public Integer iCargoCapacity;

    public Boolean bSold;
    public Integer iPurchasedYear;
    public Integer iAge;
    public Boolean bInFlight;

    public Double dWearTearPercentage;

    public void BoardPassengers();
    public void DeboardPassengers();
    public void BoardCargo();
    public void DeboardCargo();
    public void Fly();
    public void PerformMaintenance();
    public void TakeOff();
    public void Land();
}