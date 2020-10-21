package Airline.src.model;

import Airline.src.templates.AircraftTemplate;

public class Aircraft extends AircraftModel implements AircraftTemplate {

    private String sAircraftName="";

    private Integer iRemainingFuel=0;

    private Integer iCompleteFlights = 0;
    private Integer iCompleteFlightHours = 0;

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

    private Double dBaseWearRate = 0.00D;
    private Double dCurrentWearPercentage=0.00D;


    private Double dPurchasePrice = 0.00D;
    private Double dRegularMaintenanceCost=0.00D;
    private Double dCumulativeMaintenanceCosts=0.00D;
    private Double dCumulativeFuelCosts=0.00D;
    private Double dCumulativePassengerRevenue=0.00D;
    private Double dCumulativeCargoRevenue=0.00D;
    private Double dCumulativeOtherRevenue=0.00D;

    private Float dCumulativeProfitability=0.00F;

    public Aircraft(String sName, String sMfr, String sModel) {
        super(sMfr, sModel);
        this.sAircraftName = sName;
    }

    @Override
    public void BoardPassengers() {

    }

    @Override
    public void UnloadPassengers() {

    }

    @Override
    public void BoardCargo() {

    }

    @Override
    public void UnloadCargo() {

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

    private Double CalculateCurrentWear() {
        /*
        An aircraft's lifespan is measured not in years but in pressurization cycles.
        Each time an aircraft is pressurized during flight, its fuselage and wings are stressed.
        Both are made of large, plate-like parts connected with fasteners and rivets, and over time, cracks develop around the fastener holes due to metal fatigue.

        "Aircraft lifespan is established by the manufacturer," explains the Federal Aviation Administration's John Petrakis, "and is usually based on takeoff and landing cycles.
        The fuselage is most susceptible to fatigue, but the wings are too, especially on short hauls where an aircraft goes through pressurization cycles every day."
         Aircraft used on longer flights experience fewer pressurization cycles, and can last more than 20 years.
         "There are 747s out there that are 25 or 30 years old," says Petrakis.
         */

        return 0.00D;
    }

    public String toString() {
        return this.sAircraftName;
    }
}