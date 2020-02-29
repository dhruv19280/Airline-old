package Airline.src.model;

import java.time.LocalDateTime;

public class AircraftModel {

    private String sManufacturer="";
    private String sAircraftType="";
    private String sAircraftModel="";
    private String sAircraftEngine = "";
    private Integer iEnginePower = 0;

    private LocalDateTime dtManufacturedFrom;
    private LocalDateTime dtManufacturedTo;

    private Integer iFuelCapacity=0;
    private Double dFuelEconomy=0.00D;

    private Integer iMaximumRange=0;
    private Integer iMaxSpeedPerHour=0;

    private Integer iMaxEconomyCapacity=0;
    private Integer iMaxBusinessCapacity=0;
    private Integer iMaxFirstCapacity=0;
    private Integer iMaxCargoCapacity=0;

    private Integer iMinTakeOffDistance=0;
    private Integer iMinLandingDistance=0;

    private Integer iMaxPayload=0;

    private Double dWearRatePerHundredHour = 0.00D;
    private Double dBaseCost = 0.00D;

    public void PrintDetails() {
        System.out.printf("%s : %s : %s : %d : %d : %d : %d : %d : %d, %d",
                sManufacturer,
                sAircraftType,
                sAircraftModel,
                iFuelCapacity,
                iMaximumRange,
                iMaxSpeedPerHour,
                iMaxEconomyCapacity,
                iMaxBusinessCapacity,
                iMaxFirstCapacity,
                iMaxCargoCapacity);
    }

    public AircraftModel(String sMfr, String sModel, String sType, String sFrom, String sTo) {
        this.sManufacturer = sMfr;
        this.sAircraftModel = sModel;
        this.sAircraftType = sType;

        if(sFrom.length() > 0) {
            this.dtManufacturedFrom = LocalDateTime.of(Integer.parseInt(sFrom), 1,1,0,0);
        } else {
            this.dtManufacturedFrom = LocalDateTime.of(GameTime.iGameStartYear, GameTime.iGameStartMonth,GameTime.iGameStartDate,GameTime.iGameStartHour,GameTime.iGameStartMinutes);
        }


        if (sTo.length() > 1) {
            this.dtManufacturedTo = LocalDateTime.of(Integer.parseInt(sTo), 12,31,23,59);
        } else {
            this.dtManufacturedTo = LocalDateTime.of(GameTime.iGameFinishYear, GameTime.iGameFinishMonth,GameTime.iGameFinishDate,GameTime.iGameFinishHour,GameTime.iGameFinishMinutes);
        }
    }

    public void UpdateEngineSpecs(String sEngine, Integer iPower) {
        this.sAircraftEngine = sEngine;
        this.iEnginePower = iPower;
    }

    public void UpdateRangeSpeed(Integer iSpeed, Integer iRange, Double dEconomy) {
        this.iMaxSpeedPerHour = iSpeed;
        this.iMaximumRange = iRange;
        this.dFuelEconomy = dEconomy;
    }

    public void UpdatePayload(Integer iPayload, Integer iFuelTank) {
        this.iMaxPayload = iPayload;
        this.iFuelCapacity = iFuelTank;
    }

    public void UpdateVREF(Integer iTakeOffDist, Integer iLandDist) {
        this.iMinLandingDistance = iLandDist;
        this.iMinTakeOffDistance = iTakeOffDist;
    }

    public void UpdatePaxCapacities(Integer iEco, Integer iBus, Integer iFirst, Integer iCargo) {
        this.iMaxEconomyCapacity = iEco;
        this.iMaxBusinessCapacity = iBus;
        this.iMaxFirstCapacity = iFirst;
        this.iMaxCargoCapacity = iCargo;
    }

    public void UpdatePrice(Double dPrice) {
        this.dBaseCost = dPrice;
    }
}
