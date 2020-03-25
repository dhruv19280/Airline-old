package Airline.src.model;

import Airline.src.template.AirlineTemplate;

import java.util.ArrayList;
import java.util.List;

public class Airline implements AirlineTemplate {

    private String sAirlineCode="";
    private String sAirlineName="";
    private String sAirlineCountry="";

    private Boolean sAutoAirline=true;

    private Double dAirlineFunds=0.00;
    private Double dAirlineValue=0.00;

    private List<Airport> lstAirportBranches = new ArrayList<Airport>();
    private List<Aircraft> lstOwnedAircrafts = new ArrayList<Aircraft>();
    private List<Route> lstRentedRoutes = new ArrayList<Route>();
    private List<Crew> lstHiredCrew = new ArrayList<Crew>();

    public Airline(String sCode, String sName, String sCountry) {
        this.sAirlineCode = sCode;
        this.sAirlineName = sName;
        this.sAirlineCountry = sCountry;
        this.sAutoAirline = false;
    }

    @Override
    public void OpenRoute() {

    }

    @Override
    public void CloseRoute() {

    }

    @Override
    public void PurchaseAircraft() {

    }

    @Override
    public void RetireAircraft() {

    }

    @Override
    public void MaintainAircraft() {

    }

    @Override
    public void HireCrew() {

    }

    @Override
    public void FireCrew() {

    }

    @Override
    public void PaySalaries() {

    }

    @Override
    public void OpenBranch() {

    }

    @Override
    public void CloseBranch() {

    }

    @Override
    public void PayBranchRents() {

    }

    @Override
    public void DescheduleFlights() {

    }

    @Override
    public void ResearchRoute() {

    }

    @Override
    public void PayRouteRents() {

    }

    @Override
    public void PromoteRoute() {

    }

    @Override
    public void SetEconomyFare() {

    }

    @Override
    public void SetBusinessFare() {

    }

    @Override
    public void SetFirstFare() {

    }

    @Override
    public void SetCargoFare() {

    }

    @Override
    public void DeployAircraft() {

    }

    @Override
    public void UpgradeAircraft() {

    }

    @Override
    public void TrainCrew() {

    }

    @Override
    public void AssignCrew() {

    }

    @Override
    public void ScheduleFlights() {

    }

    public void PrintDetails() {
        System.out.printf("%s : %s : %s \n", sAirlineCode, sAirlineName, sAirlineCountry);
    }

    public Boolean IsValid() {
        Boolean bValid = true;

        if (this.sAirlineCode.isBlank() || this.sAirlineCode.isEmpty()) {
            bValid = false;
        }

        if (this.sAirlineName.isBlank() || this.sAirlineName.isEmpty()) {
            bValid = false;
        }

        if (this.sAirlineCountry.isBlank() || this.sAirlineCountry.isEmpty()) {
            bValid = false;
        }

        return bValid;
    }
}
