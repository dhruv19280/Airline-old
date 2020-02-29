package Airline.src.model;

public class Crew {

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