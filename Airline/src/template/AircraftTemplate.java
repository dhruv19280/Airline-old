package Airline.src.template;

import Airline.src.model.Airline;

public interface AircraftTemplate {

    public void BoardPassengers();
    public void UnloadPassengers();
    public void BoardCargo();
    public void UnloadCargo();
    public void Fly();
    public void BreakDown();
    public void PerformMaintenance();
    public void TakeOff();
    public void Land();

}