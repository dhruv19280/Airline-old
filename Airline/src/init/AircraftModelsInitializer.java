package Airline.src.init;

import Airline.src.model.AircraftModel;
import Airline.src.model.Airline;
import Airline.src.model.GameTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AircraftModelsInitializer extends Thread {

    private static final String sParentURL = "https://www.aircraftcompare.com/manufacturer-categories/airplane/";

    public static List<AircraftModel> lstAllAircraftModels;


    public static void InitializeAll() {

        lstAllAircraftModels = new ArrayList<AircraftModel>();

        //ParseParentURL(sParentURL);
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

/*    private static void ParseParentURL(String sURL) {

        Document doc = null;

        try {
            doc = Jsoup.connect(sURL).get();
            Elements tablerows = doc.select("ul.list-manufacturers a");

            int i = 0;
            for (Element row : tablerows) {

                try {
                    String sManufacturerURL = row.attr("href");
                    String sManufacturerName = row.text();

                    ParseManufacturerURL(sManufacturerName, sManufacturerURL);

                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void ParseManufacturerURL(String sManufacturerName, String sManufacturerURL) {
        Document doc = null;
        List<Thread> lstModelThreads = new ArrayList<Thread>();


        try {
            doc = Jsoup.connect(sManufacturerURL).get();
            Elements tablerows = doc.select("section.mb-4.px-3");

            for (Element row : tablerows) {

                try {
                    String sModelCategory = row.select("h3").text();
                    Elements subrows = row.select("div.media-body");

                    for (Element subrow : subrows) {
                        String sModelURL = subrow.select("a").attr("href");
                        String sModelName = subrow.select("a").text();
                        String sModelPrice = subrow.select("p").text();


                        if(
                                sModelCategory.equalsIgnoreCase("Passenger Turbo Props")
                                || sModelCategory.equalsIgnoreCase("Light Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Mid Size Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Jumbo Passenger Jets")
                                || sModelCategory.equalsIgnoreCase("Cargo Airplanes")
                        ) {
                            //System.out.println("Processing : " + sManufacturerName + " : " + sModelCategory + " : " + sModelName + " : " + sModelPrice + " : " + sModelURL);
                            lstModelThreads.add(new Thread(() -> {ParseModelURL(sModelURL, sManufacturerName, sModelCategory, sModelName, sModelPrice);}));
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
                for (int i = 0; i < lstModelThreads.size(); i++)
                {
                    lstModelThreads.get(i).start();
                }
                for (int i = 0; i < lstModelThreads.size(); i++)
                {
                    lstModelThreads.get(i).join();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void ParseModelURL(String sURL, String sMfr, String sCategory, String sModel, String sPrice) {
        Document doc = null;

        try {
            String sFrom = "";
            String sTo="";
            String sEngine = "";
            String sPower = "";
            String sSpeed = "";
            String sRange = "";
            String sFuelEconomy = "";
            String sTakeOffDistance = "";
            String sLandingDistance = "";
            String sPayload = "";
            String sTankCapacity = "";
            String sSeatsEconomy = "";
            String sSeatsBusiness = "";
            String sSeatsFirst = "";
            String sCargoVolume = "";

            doc = Jsoup.connect(sURL).get();

            Elements toprows = doc.select("dl.row");
            Elements dates = toprows.select("dd.col-6.mb-0");

            sFrom = dates.get(2).text().substring(0,4);
            sTo = dates.get(2).text().substring(8);
            sTo = sTo.replaceAll("Present", GameTime.iGameFinishYear.toString()). replaceAll("Onward", GameTime.iGameFinishYear.toString()).trim();

            Elements tablerows = doc.select("dl.row.mb-0");

            for (Element row : tablerows) {
                Elements headers = row.select("dt");
                Elements values = row.select("dd");

                for (int i = 0; i < headers.size(); i++) {
                    try {

                        if (headers.get(i).text().contains("Engine")) sEngine = values.get(i).text();
                        if (headers.get(i).text().contains("Power")) sPower = values.get(i).text();
                        if (headers.get(i).text().contains("Cruise Speed")) sSpeed = values.get(i).text();
                        if (headers.get(i).text().contains("range")) sRange = values.get(i).text();
                        if (headers.get(i).text().contains("Fuel Economy")) sFuelEconomy = values.get(i).text();
                        if (headers.get(i).text().contains("Take Off Distance")) sTakeOffDistance = values.get(i).text();
                        if (headers.get(i).text().contains("Landing Distance")) sLandingDistance = values.get(i).text();
                        if (headers.get(i).text().contains("Payload")) sPayload = values.get(i).text();
                        if (headers.get(i).text().contains("Tank Capacity")) sTankCapacity = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - Economy")) sSeatsEconomy = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - Business")) sSeatsBusiness = values.get(i).text();
                        if (headers.get(i).text().contains("Seats - First")) sSeatsFirst = values.get(i).text();
                        if (headers.get(i).text().contains("Baggage Volume")) sCargoVolume = values.get(i).text();
                        //System.out.println("Processing : " + headers.get(i).text() + " : " + values.get(i).text());

                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
            ///System.out.println("Creating Object : " + sMfr + " : " + sCategory + " : " +sModel + " : " + sFrom + " : " + sTo);
            AircraftModel am = null;
            if(sCategory.contains("Passenger")) {
                am = new AircraftModel(sMfr, sModel, "Passenger", sFrom, sTo);
            } else {
                am = new AircraftModel(sMfr, sModel, "Cargo", sFrom, sTo);
            }

            sPrice = sPrice.replaceAll("\\$", "").trim();
            sPrice = sPrice.replaceAll("Price:", "").trim();
            sPrice = sPrice.replaceAll("\\s+", "");
            sPrice = sPrice.replaceAll("MillionUSD", "").trim();
            if(sPrice.isBlank() || sPrice.isEmpty()) {
                sPrice = "0.00";
            }
            am.UpdatePrice(Double.parseDouble(sPrice) * 1000000);

            //am.UpdateEngineSpecs(sEngine, sPower);


            if(sPayload.isEmpty() || sPayload.isBlank()) {
                sPayload = "0";
            } else {
                sPayload = sPayload.substring(0, sPayload.indexOf(' ')).trim();
                sPayload = sPayload.replaceAll(",", "").trim();
            }

            if (!sTankCapacity.isBlank() && !sTankCapacity.isEmpty()) {
                sTankCapacity = sTankCapacity.split("\\s+")[2].trim();
                sTankCapacity = sTankCapacity.replaceAll(",", "").trim();
            } else
            {
                sTankCapacity = "0";
            }
            //am.UpdatePayload(Integer.parseInt(sPayload), Integer.parseInt(sTankCapacity));


            sTakeOffDistance = sTakeOffDistance.substring(0, sTakeOffDistance.indexOf(' ')+1).trim();
            if(sTakeOffDistance.isEmpty() || sTakeOffDistance.isBlank()) sTakeOffDistance = "0";
            if (sTakeOffDistance.contains("."))
            sTakeOffDistance = sTakeOffDistance.substring(0, sTakeOffDistance.indexOf('.')).trim();


            sLandingDistance = sLandingDistance.substring(0, sLandingDistance.indexOf(' ')+1).trim();
            if(sLandingDistance.isEmpty() || sLandingDistance.isBlank()) sLandingDistance = "0";
            if(sLandingDistance.contains("."))
            sLandingDistance = sLandingDistance.substring(0, sLandingDistance.indexOf('.')).trim();

            //am.UpdateVREF(Integer.parseInt(sTakeOffDistance), Integer.parseInt(sLandingDistance));

            //840 Nautical Miles 1,556 Kilometers
            sRange = sRange.replaceAll("Nautical Miles", "").replaceAll("Kilometers", "").trim();
            sRange = sRange.replaceAll(",", "").trim();
            if(sRange.isBlank() || sRange.isEmpty()) {
                sRange = "0";
            } else
            {
                sRange = sRange.split("\\s+")[1].trim();
            }

            //410 knots 759 Km/h
            sSpeed = sSpeed.replaceAll("knots", "").replaceAll("Km/h", "").trim();
            sSpeed = sSpeed.replaceAll(",", "").trim();
            if (sSpeed.isBlank() || sSpeed.isEmpty()) {
                sSpeed = "0";
            } else
            {
                sSpeed = sSpeed.split("\\s+")[1].trim();
            }

            //1.55 nautical mile / gallon 0.758 kilometres / litre
            sFuelEconomy = sFuelEconomy.replaceAll("nautical mile / gallon", "").replaceAll("kilometres / litre", "").trim();
            sFuelEconomy = sFuelEconomy.replaceAll(",", "").trim();

            if (!sFuelEconomy.isBlank() && !sFuelEconomy.isEmpty()) {
                sFuelEconomy = sFuelEconomy.split("\\s+")[1].trim();
            } else
            {
                sFuelEconomy = "0.00";
            }

            //am.UpdateRangeSpeed(Integer.parseInt(sSpeed), Integer.parseInt(sRange), Double.parseDouble(sFuelEconomy));

            //189 seats
            sSeatsEconomy = sSeatsEconomy.replaceAll("seats", "").trim();
            if (sSeatsEconomy.isBlank() || sSeatsEconomy.isEmpty()) sSeatsEconomy = "0";

            sSeatsBusiness = sSeatsBusiness.replaceAll("seats", "").trim();
            if (sSeatsBusiness.isBlank() || sSeatsBusiness.isEmpty()) sSeatsBusiness = "0";

            sSeatsFirst = sSeatsFirst.replaceAll("seats", "").trim();
            if (sSeatsFirst.isBlank() || sSeatsFirst.isEmpty()) sSeatsFirst = "0";

            //1845 m3 / 65,156 ft3
            sCargoVolume = sCargoVolume.replaceAll("m3","").replaceAll("ft3", "").trim();
            sCargoVolume = sCargoVolume.replaceAll(",", "").trim();
            if (!sCargoVolume.isBlank() && !sCargoVolume.isEmpty()) {
                sCargoVolume = sCargoVolume.split("\\s+")[0].trim();
            } else
            {
                sCargoVolume = "0.00";
            }
            //am.UpdatePaxCapacities(Integer.parseInt(sSeatsEconomy), Integer.parseInt(sSeatsBusiness), Integer.parseInt(sSeatsFirst), Float.parseFloat(sCargoVolume));

            //System.out.println("Adding Object : " + sMfr + " : " + sCategory + " : " +sModel + " : " + sFrom + " : " + sTo);
            lstAllAircraftModels.add(am);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

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
