package Airline.src.model;

public class Airport {

    private String sAirportName;
    private String sAirportICAO;
    private String sAirportSize;
    
    private String sAirportCountry;
    private String sAirportCity;

    private Double dLatitude;
    private Double dLongitude;

    private Integer iPassengerCapacity;
    private Integer iCargoCapacity;

    private Integer iWaitingPassengers;
    private Integer iWaitingCargo;

    private Integer iTotalSlots;
    private Integer iOccupiedSlots;
    private Integer iAvailableSlots;
    
    private Double dBranchSetupCost;
    private Double dBrandDemolishCost;
    private Double dBranchRegularCost;

    private Double dConnectivityRating;
    private Double dFacilitiesRating;
    private Double dPunctualityRating;

    Airport(String sName, String sICAO, String sCountry, String sCity, Integer iFlights) {
        
        sAirportName = sName;
        sAirportICAO = sICAO;
        sAirportCountry = sCountry;
        sAirportCity = sCity;

        DeriveOtherFields(iFlights);
    }

    private void DeriveOtherFields(Integer iFlights) {

        if (iFlights >= 750 && iFlights <1000) {
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
        else if (iFlights >=500 && iFlights<750 ) {
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
        else if (iFlights >=250 && iFlights<500) {
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

    public void GeneratePassengers() {
        
    }

    public void DeliverPassengers() {

    }

    public void GenerateCargo() {

    }

    public void DeliverCargo() {

    }

    public void AircraftArrival() {

    }

    public void AircraftDeparture() {
        
    }

    public void AllocateSlots() {

    }

    public void DeallocateSlots() {

    }

    public void StartUpgradeAirport() {

    }

    public void CompleteUpgradeAirport() {

    }

}