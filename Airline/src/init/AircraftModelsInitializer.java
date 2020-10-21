package Airline.src.init;

import Airline.src.model.AircraftModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AircraftModelsInitializer extends Thread {

    public static List<AircraftModel> lstAllAircraftModels;

    public static void InitializeAll() {

        lstAllAircraftModels = new ArrayList<AircraftModel>();
        lstAllAircraftModels = ParseFileIntoAircrafts("airplanes.csv");

        System.out.println(lstAllAircraftModels.size() + ": Size of AircraftModels Before Cleanup");
        CleanUpAircraftModels();
        System.out.println(lstAllAircraftModels.size() + ": Size of AircraftModels After Cleanup");
    }

    private static List<AircraftModel> ParseFileIntoAircrafts(String sFile) {
        /*
        0manufacturer,1name,2price,3type,4body,5rangetype,6engine,7wingspan,8length,
        9range,10speed,11fuelcapacity,12consumption,13runwaylengthrequired,14passengers,
        15cockpitcrew,16cabincrew,17maxclasses,18cargo,19from,20to,21rate
        */

        String DEFAULT_SEPARATOR = ",";
        List lstAircraftModels = new ArrayList<AircraftModel>();

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(sFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            if (i==0) {
                i++;
                continue;
            } else {
                String[] values = line.split(DEFAULT_SEPARATOR);

                String sMfr = values[0];
                String sModel = values[1];
                String sPrice = values[2];
                String sType = values[3];
                String sBody = values[4];
                String sRangeType = values[5];
                String sEngine = values[6];
                String sWingspan = values[7];
                String sLength = values[8];
                String sRange = values[9];
                String sSpeed = values[10];
                String sFuelCapacity = values[11];
                String sConsumption = values[12];
                String sRunwayLength = values[13];
                String sPassengers = values[14];
                String sCockpitCrew = values[15];
                String sCabinCrew = values[16];
                String sMaxClasses=values[17];
                String sCargo = values[18];
                String sFrom = values[19];
                String sTo = values[20];
                String sWear = values[21];

                AircraftModel am = new AircraftModel(sMfr,sModel, sType, sFrom, sTo);
                am.UpdateEngineBody(sEngine, sBody);
                am.UpdatePrice(Double.parseDouble(sPrice));
                am.UpdateRangeSpeed(Integer.parseInt(sSpeed), Integer.parseInt(sRange), sRangeType);
                am.UpdateFuel(Integer.parseInt(sFuelCapacity), Float.parseFloat(sConsumption));
                am.UpdateVREF(Integer.parseInt(sRunwayLength));
                am.UpdateVitals(Float.parseFloat(sWingspan), Float.parseFloat(sLength), Float.parseFloat(sWear));
                am.UpdateCrewRequirements(Integer.parseInt(sCockpitCrew), Integer.parseInt(sCabinCrew));
                am.UpdatePaxCapacities(Integer.parseInt(sPassengers), Integer.parseInt(sMaxClasses));
                am.UpdateCargoCapacity(Float.parseFloat(sCargo));

                lstAircraftModels.add(am);

                i++;
            }

        }

        scanner.close();
        return lstAircraftModels;
    }

    public static void PrintAllAircraftModels() {
        for (AircraftModel a : lstAllAircraftModels) {
            a.PrintDetails();
        }
    }

    private static void CleanUpAircraftModels() {

        for(int i = 0; i<lstAllAircraftModels.size(); i++){
            //System.out.println(myList.get(i));
            if(!lstAllAircraftModels.get(i).IsValid()){
                lstAllAircraftModels.remove(i);
                i--;
            }
        }
    }

    public void run() {

    }

}
