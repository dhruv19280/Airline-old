package Airline.src.model;

import Airline.src.templates.AirportTemplate;

public class Airport implements AirportTemplate {

    private String sAirportName = "";
    private String sAirportIATA = "";
    private String sAirportSize = "";

    private String sAirportCountry = "";
    private String sAirportCity = "";

    private Double dLatitude=0.00D;
    private Double dLongitude=0.00D;
    private Integer iElevation=0;

    private Integer iPassengerCapacity = 0;
    private Integer iCargoCapacity = 0;

    private Integer iWaitingPassengers = 0;
    private Integer iWaitingCargo = 0;

    private Integer iTotalSlots = 0;
    private Integer iOccupiedSlots = 0;
    private Integer iAvailableSlots = 0;

    private Double dBranchSetupCost = 0.00D;
    private Double dBrandDemolishCost = 0.00D;
    private Double dBranchRegularCost = 0.00D;

    private Double dConnectivityRating = 0.00D;
    private Double dFacilitiesRating = 0.00D;
    private Double dPunctualityRating = 0.00D;

    private Boolean bIsValid = false;

    private Integer iAircraftCount = 0;


    public Airport(String sIATA) {

        this.sAirportIATA = sIATA;
    }

    public void DeriveOtherFields(Integer iFlights) {

        if (iFlights >= 450 && iFlights <1000) {
            sAirportSize = "Very Large";
            iPassengerCapacity = 5000;
            iCargoCapacity = 500;
        
            iWaitingPassengers = 0;
            iWaitingCargo = 0;
        
            iTotalSlots = 500;
            iOccupiedSlots = 0;
            iAvailableSlots = iTotalSlots - iOccupiedSlots;
            
            dBranchSetupCost = 5000000D;
            dBrandDemolishCost = 5000000D;
            dBranchRegularCost = 100000D;

            dConnectivityRating = 3.00D;
            dFacilitiesRating = 3.00D;
            dPunctualityRating = 3.00D;
        }
        else if (iFlights >=200 && iFlights<449 ) {
            sAirportSize = "Large";
            iPassengerCapacity = 2500;
            iCargoCapacity = 250;
        
            iWaitingPassengers = 0;
            iWaitingCargo = 0;
        
            iTotalSlots = 250;
            iOccupiedSlots = 0;
            iAvailableSlots = iTotalSlots - iOccupiedSlots;
            
            dBranchSetupCost = 2500000D;
            dBrandDemolishCost = 2500000D;
            dBranchRegularCost = 50000D;

            dConnectivityRating = 2.00D;
            dFacilitiesRating = 2.00D;
            dPunctualityRating = 2.00D;            
        }
        else if (iFlights >=50 && iFlights<199) {
            sAirportSize = "Medium";
            iPassengerCapacity = 1000;
            iCargoCapacity = 100;
        
            iWaitingPassengers = 0;
            iWaitingCargo = 0;
        
            iTotalSlots = 100;
            iOccupiedSlots = 0;
            iAvailableSlots = iTotalSlots - iOccupiedSlots;
            
            dBranchSetupCost = 1000000D;
            dBrandDemolishCost = 1000000D;
            dBranchRegularCost = 20000D;
            
            dConnectivityRating = 1.00D;
            dFacilitiesRating = 1.00D;
            dPunctualityRating = 1.00D;            
        }
        else {
            sAirportSize = "Small";
            iPassengerCapacity = 500;
            iCargoCapacity = 50;
        
            iWaitingPassengers = 0;
            iWaitingCargo = 0;
        
            iTotalSlots = 50;
            iOccupiedSlots = 0;
            iAvailableSlots = iTotalSlots - iOccupiedSlots;
            
            dBranchSetupCost = 5000000D;
            dBrandDemolishCost = 500000D;
            dBranchRegularCost = 10000D;

            dConnectivityRating = 0.50D;
            dFacilitiesRating = 0.50D;
            dPunctualityRating = 0.50D;            
        }

    }

    public void UpdateInitialize(String sName, String sCountry, String sCity, String sLat, String sLong, String sElev) {
        this.sAirportName = sName;
        this.sAirportCountry = sCountry;
        this.sAirportCity = sCity;
        this.dLatitude = Double.parseDouble(sLat);
        this.dLongitude = Double.parseDouble(sLong);
        this.iElevation = Integer.parseInt(sElev);
        this.bIsValid = true;
    }

    public Boolean IsValid() {
        boolean valid = true;
        if(this.sAirportIATA.length() < 2) {
            valid = false;
        }
        if(this.sAirportName.length() < 5) {
            valid = false;
        }
        if(this.sAirportCountry.length() < 3) {
            valid = false;
        }
        if(this.sAirportCity.length() < 3) {
            valid = false;
        }
        if(this.dLatitude.isNaN()) {
            valid = false;
        }
        if(this.dLongitude.isNaN()) {
            valid = false;
        }
        this.bIsValid = valid;
        return this.bIsValid;
    }

    public void PrintDetails() {
        System.out.println(
                sAirportIATA + ":" +
                sAirportName + ":" +
                sAirportCountry + ":" +
                sAirportCity + ":" +
                sAirportSize + ":" +
                iPassengerCapacity + ":" +
                iTotalSlots + ":" +
                dLatitude.toString() + ":" +
                dLongitude.toString()+ ":" +
                iElevation.toString());
    }

    @Override
    public void AircraftArrival() {
        this.iAircraftCount++;
    }

    @Override
    public void AircraftDeparture() {
        if(this.iAircraftCount > 0) this.iAircraftCount--;
    }

    @Override
    public void AllocateSlots() {

    }

    @Override
    public void DeallocateSlots() {

    }

    @Override
    public void StartUpgradeAirport() {

    }

    @Override
    public void CompleteUpgradeAirport() {

    }
}