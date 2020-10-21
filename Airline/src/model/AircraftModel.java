package Airline.src.model;

import java.time.LocalDateTime;

public class AircraftModel {

    private String sManufacturer = "";
    private String sAircraftType = "";
    private String sAircraftModel = "";

    private String sEngineType = "";
    private String sBodyType = "";

    private Float fWingspan = 0.000F;
    private Float fLength = 0.000F;

    private LocalDateTime dtManufacturedFrom;
    private LocalDateTime dtManufacturedTo;

    private Integer iFuelCapacity = 0;
    private Float fFuelConsumption = 0.0000F;

    private String sRangeType = "";
    private Integer iMaximumRange = 0;
    private Integer iMaxSpeedPerHour = 0;

    private Integer iMaxEconomyCapacity = 0;
    private Integer iMaxClasses = 0;
    private Float fMaxCargoCapacity = 0.0F;

    private Integer iMinCockpitCrew = 0;
    private Integer iMinCabinCrew = 0;
    private Integer iMinTakeOffDistance = 0;

    private Float fBaseWearRate = 0.0000F;
    private Double dBasePrice = 0.00D;

    public void PrintDetails() {
        System.out.printf("%s : %s : %s : %s : %s : %s : %s : %s : %d : %d, %d : %d : %d : %d : %d : %d : %f : %f : %f : %f : %f : %f \n",
                sManufacturer,
                sAircraftType,
                sAircraftModel,
                sEngineType,
                sBodyType,
                sRangeType,
                dtManufacturedFrom.toString(),
                dtManufacturedTo.toString(),
                iFuelCapacity,
                iMaximumRange,
                iMaxSpeedPerHour,
                iMaxEconomyCapacity,
                iMaxClasses,
                iMinTakeOffDistance,
                iMinCockpitCrew,
                iMinCabinCrew,
                fMaxCargoCapacity,
                fWingspan,
                fLength,
                dBasePrice,
                fFuelConsumption,
                fBaseWearRate);
    }

    public AircraftModel(String sMfr, String sModel, String sType, String sFrom, String sTo) {
        this.sManufacturer = sMfr;
        this.sAircraftModel = sModel;
        this.sAircraftType = sType;

        if (sFrom.length() > 0) {
            this.dtManufacturedFrom = LocalDateTime.of(Integer.parseInt(sFrom), 1, 1, 0, 0);
        } else {
            this.dtManufacturedFrom = LocalDateTime.of(GameTime.iGameStartYear, GameTime.iGameStartMonth, GameTime.iGameStartDate, GameTime.iGameStartHour, GameTime.iGameStartMinutes);
        }


        if (sTo.length() > 1) {
            this.dtManufacturedTo = LocalDateTime.of(Integer.parseInt(sTo), 12, 31, 23, 59);
        } else {
            this.dtManufacturedTo = LocalDateTime.of(GameTime.iGameFinishYear, GameTime.iGameFinishMonth, GameTime.iGameFinishDate, GameTime.iGameFinishHour, GameTime.iGameFinishMinutes);
        }
    }

    public AircraftModel(String sMfr, String sModel) {
        this.sManufacturer = sMfr;
        this.sAircraftModel = sModel;
    }

    public void UpdateEngineBody(String sEngineType, String sBody) {
        this.sEngineType = sEngineType;
        this.sBodyType = sBody;
    }

    public void UpdateRangeSpeed(Integer iSpeed, Integer iRange, String sRangeType) {
        this.iMaxSpeedPerHour = iSpeed;
        this.iMaximumRange = iRange;
        this.sRangeType = sRangeType;
    }

    public void UpdateFuel(Integer iFuelTank, Float fEconomy) {
        this.iFuelCapacity = iFuelTank;
        this.fFuelConsumption = fEconomy;
    }

    public void UpdateVREF(Integer iTakeOffDist) {
        this.iMinTakeOffDistance = iTakeOffDist;
    }

    public void UpdatePaxCapacities(Integer iEco, Integer iClasses) {
        this.iMaxEconomyCapacity = iEco;
        this.iMaxClasses= iClasses;
    }

    public void UpdateCargoCapacity(Float fCargo) {
        this.fMaxCargoCapacity = fCargo;
    }

    public void UpdatePrice(Double dPrice) {
        this.dBasePrice = dPrice;
    }

    public void UpdateVitals(Float fWings,Float fLength, Float fWear) {
        this.fWingspan = fWings;
        this.fLength = fLength;
        this.fBaseWearRate = fWear;
    }

    public void UpdateCrewRequirements(Integer iCockpit, Integer iCabin) {
        this.iMinCockpitCrew = iCockpit;
        this.iMinCabinCrew = iCabin;
    }

    public Boolean IsValid() {
        Boolean bValid = true;

        if (this.sManufacturer.isBlank() || this.sManufacturer.isEmpty()) {
            bValid = false;
        }

        if (this.sAircraftModel.isBlank() || this.sAircraftModel.isEmpty()) {
            bValid = false;
        }

        if (this.sAircraftType.isBlank() || this.sAircraftType.isEmpty()) {
            bValid = false;
        }

        if (this.iMaxEconomyCapacity == 0 && this.fMaxCargoCapacity == 0.00F) {
            bValid = false;
        }

        if (this.dBasePrice == 0) {
            bValid = false;
        }

        if (this.iMaximumRange == 0 || iMaxSpeedPerHour == 0) {
            bValid = false;
        }

        return bValid;
    }
}
