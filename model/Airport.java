package Airline.model;

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
            
            dBranchSetupCost = 5000000;
            dBrandDemolishCost = 5000000;
            dBranchRegularCost = 100000;

            dConnectivityRating = 3.00;
            dFacilitiesRating = 3.00;
            dPunctualityRating = 3.00;
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
            
            dBranchSetupCost = 2500000;
            dBrandDemolishCost = 2500000;
            dBranchRegularCost = 50000;

            dConnectivityRating = 2.00;
            dFacilitiesRating = 2.00;
            dPunctualityRating = 2.00;            
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
            
            dBranchSetupCost = 1000000;
            dBrandDemolishCost = 1000000;
            dBranchRegularCost = 20000;
            
            dConnectivityRating = 1.00;
            dFacilitiesRating = 1.00;
            dPunctualityRating = 1.00;            
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
            
            dBranchSetupCost = 500000;
            dBrandDemolishCost = 500000;
            dBranchRegularCost = 10000;

            dConnectivityRating = 0.50;
            dFacilitiesRating = 0.50;
            dPunctualityRating = 0.50;            
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