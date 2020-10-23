package Airline.src.model;

import Airline.src.templates.AirlineTemplate;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Airline implements AirlineTemplate {

    private final Double INIT_AIRLINE_START_FUNDS = 50000000D;
    private final Double INIT_AIRLINE_START_VALUE = 50000000D;

    private String sAirlineCode="";
    private String sAirlineName="";
    private String sAirlineCountry="";

    private Boolean sAutoAirline=true;

    private Double dAirlineFunds=0.00;
    private Double dAirlineValue=0.00;

    public List<Airport> lstAirportBranches = new ArrayList<Airport>();
    public List<Aircraft> lstOwnedAircrafts = new ArrayList<Aircraft>();
    public List<Route> lstRentedRoutes = new ArrayList<Route>();
    public List<Crew> lstHiredCrew = new ArrayList<Crew>();

    public Airline(String sCode, String sName, String sCountry) {
        this.sAirlineCode = sCode;
        this.sAirlineName = sName;
        this.sAirlineCountry = sCountry;
        this.sAutoAirline = false;

        this.dAirlineFunds = INIT_AIRLINE_START_FUNDS;
        this.dAirlineValue = INIT_AIRLINE_START_VALUE;
    }

    public List<String> GetAircraftsList() {
        List <String> lstAircraftNames = new ArrayList<String>();
        for (Aircraft a : lstOwnedAircrafts) {
            lstAircraftNames.add(a.toString());
        }
        return lstAircraftNames;
    }

    @Override
    public void OpenRoute(Route route) {
        //TODO: Check if the route exists in the list of Rented Routes first.
        lstRentedRoutes.add(route);
    }

    @Override
    public void CloseRoute(Route route) {
        //TODO: Check if the route exists in the list of Rented Routes first.
        lstRentedRoutes.remove(route);
    }

    @Override
    public void ResearchRoute(Route route) {

    }

    @Override
    public void PayRouteRents(Route route) {

    }

    @Override
    public void PromoteRoute(Route route) {

    }

    @Override
    public void SetEconomyFare(Route route) {

    }

    @Override
    public void SetBusinessFare(Route route) {

    }

    @Override
    public void SetFirstFare(Route route) {

    }

    @Override
    public void SetCargoFare(Route route) {

    }

    @Override
    public void PurchaseAircraft(Aircraft a, Double value) {
        lstOwnedAircrafts.add(a);
        dAirlineFunds = dAirlineFunds - value;
        dAirlineValue = dAirlineValue + (value*0.70);
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

    public String toString() {
        return "[" + this.sAirlineCode + "] " + this.sAirlineName;
    }
    public String getAirlineBase() {return this.sAirlineCountry;}
    public String getAirlineName() {return this.sAirlineName;}

    public String getAirlineFunds() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return format.format(this.dAirlineFunds);
    }
    public String getAirlineValue() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return format.format(this.dAirlineValue);
    }
}
