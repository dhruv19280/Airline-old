package Airline.src.templates;

public interface CrewTemplate {

    //General Actions - Applicable to All Crew Members
    public void AttendOffice();
    public void FallSick();

    //Ground Personnel Actions
    public void CheckInPassengers();
    public void LoadBaggage();
    public void UnloadBaggage();
    public void GuidePassengers();
    public void UpkeepAircraft();
    public void LoadFuelOnAircraft();
    public void LoadMealsOnAircraft();

    //Pilot Actions
    public void FlyAircraft();
    public void CheckAircraft();
    public void TakeOffAircraft();
    public void LandAircraft();
    public void TaxiAircraft();

    //AirHostess Actions
    public void SecurePassengers();
    public void SafetyAnnouncements();

    //Management Actions
    public void AssignCrewToFlights();

}
