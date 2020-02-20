package Airline.src.model;

import java.util.ArrayList;
import java.util.List;

public class Airline implements AirlineTemplate {

    private String sAirlineCode="";
    private String sAirlineName="";

    private Boolean sAutoAirline=true;

    private Double dAirlineFunds=0.00;
    private Double dAirlineValue=0.00;

    private List<Airport> lstAirportsBranches = new ArrayList<Airport>();
    private List<Aircraft> lstOwnedAircrafts = new ArrayList<Aircraft>();
    private List<Route> lstOwnedRoutes = new ArrayList<Route>();
    private List<Crew> lstHiredCrew = new ArrayList<Crew>();

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
}
