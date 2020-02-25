package Airline.src.model;

public class AircraftModel {

    private String sManufacturer="";
    private String sAircraftType="";
    private String sAircraftModel="";

    private Integer iFuelCapacity=0;
    private Double dConsumptionLitersPerPaxPerHundredKM=0.00D;

    private Integer iMaximumRange=0;
    private Integer iMaxSpeedPerHour=0;

    private Integer iEconomyPassengerCapacity=0;
    private Integer iBusinessPassengerCapacity=0;
    private Integer iFirstPassengerCapacity=0;
    private Integer iCargoCapacity=0;

    private Double dWearRatePerHundredHour = 0.00D;

    public void PrintDetails() {
        System.out.printf("%s : %s : %s : %d : %d : %d : %d : %d : %d, %d",
                sManufacturer,
                sAircraftType,
                sAircraftModel,
                iFuelCapacity,
                iMaximumRange,
                iMaxSpeedPerHour,
                iEconomyPassengerCapacity,
                iBusinessPassengerCapacity,
                iFirstPassengerCapacity,
                iCargoCapacity);
    }
    
}
