package Airline.src.templates;

import Airline.src.model.Aircraft;
import Airline.src.model.Route;

public interface AirlineTemplate {

// Route Operations
    public void OpenRoute(Route route);
    public void CloseRoute(Route route);
    public void ResearchRoute(Route route);
    public void PayRouteRents(Route route);
    public void PromoteRoute(Route route);
    public void SetEconomyFare(Route route);
    public void SetBusinessFare(Route route);
    public void SetFirstFare(Route route);
    public void SetCargoFare(Route route);


// Aircraft Operations
    public void PurchaseAircraft(Aircraft a, Double value);
    public void DeployAircraft();
    public void UpgradeAircraft();
    public void MaintainAircraft();
    public void RetireAircraft();


// Crew Operations
    public void HireCrew();
    public void TrainCrew();
    public void AssignCrew();
    public void PaySalaries();
    public void FireCrew();

//Airport Operations
    public void OpenBranch();
    public void CloseBranch();
    public void PayBranchRents();


// Flight Schedule Operations
    public void ScheduleFlights();
    public void DescheduleFlights();
}
