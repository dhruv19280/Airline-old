package Airline.src.model;

import Airline.src.templates.CrewTemplate;

public class Crew implements CrewTemplate {

    private String sFirstName;
    private String sLastName;
    private String sGender;
    private EmployeeType sType;

    private Integer iAge;
    private Integer iExperience;
    private EmployeeLevel iLevel;

    private Double dHiringCost;
    private Double dFiringCost;
    private Double dSalary;

    private Boolean bHired;


    @Override
    public void AttendOffice() {

    }

    @Override
    public void FallSick() {

    }

    @Override
    public void CheckInPassengers() {

    }

    @Override
    public void LoadBaggage() {

    }

    @Override
    public void UnloadBaggage() {

    }

    @Override
    public void GuidePassengers() {

    }

    @Override
    public void UpkeepAircraft() {

    }

    @Override
    public void LoadFuelOnAircraft() {

    }

    @Override
    public void LoadMealsOnAircraft() {

    }

    @Override
    public void FlyAircraft() {

    }

    @Override
    public void CheckAircraft() {

    }

    @Override
    public void TakeOffAircraft() {

    }

    @Override
    public void LandAircraft() {

    }

    @Override
    public void TaxiAircraft() {

    }

    @Override
    public void SecurePassengers() {

    }

    @Override
    public void SafetyAnnouncements() {

    }

    @Override
    public void AssignCrewToFlights() {

    }
}

enum EmployeeLevel {
    Contractors,
    Fresh_Recruits,
    Entry_Level,
    Professionals,
    Managers,
    Executives
}

enum EmployeeType {
    Pilot,
    Ground,
    AirHostess,
    Management
}

/*

Most Common Male First Names of the World

James
John
Robert
Michael
William
David
Richard
Joseph
Thomas
Charles
Christopher
Daniel
Matthew
Anthony
Donald
Mark
Paul
Steven
Andrew
Kenneth

Most Common Female First Names of the World

Mary
Patricia
Jennifer
Linda
Elizabeth
Barbara
Susan
Jessica
Sarah
Karen
Nancy
Margaret
Lisa
Betty
Dorothy
Sandra
Ashley
Kimberly
Donna
Emily


Most Common Surnames of the World!
Wang
Devi
Zhang
Li
Liu
Singh
Yang
Kumar
Wu
Xu
Smith
Johnson
Williams
Brown
Jones
Miller
Davis
Wilson
Anderson
Taylor
Latu
Gonzales
Rodriguez
Hernandez
Murphy
Perera
Nguyen
Nkosi
Ahmad
Ali
Phiri
Ibrahim
Moyo
Tesfaye
Sato
Hansen
Garcia
Silva
Ivanov
Rossi
Nowak
Williams




1. James Smith - 38,313
2. Michael Smith - 34,810
3. Robert Smith - 34,269
4. Maria Garcia - 32,092
5. David Smith - 31,294
6. Maria Rodriguez - 30,507
7. Mary Smith - 28,692
8. Maria Hernandez - 27,836
9. Maria Martinez - 26,956
10. James Johnson - 26,850
11. William Smith - 26,074
12. Robert Johnson - 28,874
13. John Smith - 25,255




 */