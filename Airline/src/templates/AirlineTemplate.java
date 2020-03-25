package Airline.src.templates;

public interface AirlineTemplate {

// Route Operations
    public void OpenRoute();
    public void CloseRoute();
    public void ResearchRoute();
    public void PayRouteRents();
    public void PromoteRoute();
    public void SetEconomyFare();
    public void SetBusinessFare();
    public void SetFirstFare();
    public void SetCargoFare();


// Aircraft Operations
    public void PurchaseAircraft();
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
