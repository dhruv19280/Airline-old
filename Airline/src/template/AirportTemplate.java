package Airline.src.template;

import Airline.src.model.Airline;

public interface AirportTemplate {

    public void AircraftArrival();
    public void AircraftDeparture();
    public void AllocateSlots();
    public void DeallocateSlots();
    public void StartUpgradeAirport();
    public void CompleteUpgradeAirport();

}
