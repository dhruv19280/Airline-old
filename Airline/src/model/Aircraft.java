package Airline.src.model;

import Airline.src.init.AircraftModelsInitializer;
import Airline.src.templates.AircraftTemplate;

public class Aircraft extends AircraftModel implements AircraftTemplate {

    public String sAircraftName="";

    public Integer iRemainingFuel=0;

    public Integer iCompleteFlights = 0;
    public Integer iCompleteFlightHours = 0;

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

    public Float fBaseWearRate = 0.00F;
    public Double dCurrentWearPercentage=0.00D;


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
        this.iPurchasedYear = GameTime.GetGameCurrentYear();
        PopulateAircraftModelAttributes();
    }

    private void PopulateAircraftModelAttributes() {
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            if(m.sManufacturer.equals(this.sManufacturer) && m.sAircraftModel.equals(this.sAircraftModel)) {
                this.iFuelCapacity = m.iFuelCapacity;
                this.iCargoCapacity = m.iFuelCapacity;
                this.iEconomyPassengerCapacity = m.iMaxEconomyCapacity;
                this.iBusinessPassengerCapacity = 0;
                this.iFirstPassengerCapacity = 0;
                this.sRangeType = m.sRangeType;
                this.sEngineType = m.sEngineType;
                this.sBodyType = m.sBodyType;
                this.sAircraftType = m.sAircraftType;
                this.iAge = 0;
                this.fBaseWearRate = m.fBaseWearRate;
                this.dPurchasePrice = m.dBasePrice;
                this.fWingspan = m.fWingspan;
                this.fLength = m.fLength;
                this.iMaximumRange = m.iMaximumRange;
                this.iMaxSpeedPerHour = m.iMaxSpeedPerHour;
                this.fFuelConsumption = m.fFuelConsumption;
                this.iMinTakeOffDistance = m.iMinTakeOffDistance;
                this.iMinCabinCrew = m.iMinCabinCrew;
                this.iMinCockpitCrew = m.iMinCockpitCrew;
                this.iMaxClasses = m.iMaxClasses;
            }
        }
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
        return this.sAircraftName + " ( " + this.sAircraftModel + " )";
    }
}