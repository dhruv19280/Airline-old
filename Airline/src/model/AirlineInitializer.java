package Airline.src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineInitializer {

    public static List<Airline> lstAllAirlines;

    public static void InitializeAll() {

        String sFileName = "airlines.csv";
        lstAllAirlines = new ArrayList<Airline>();

        lstAllAirlines.addAll(ParseFileIntoAirlines(sFileName));

        System.out.println(lstAllAirlines.size() + ": Size of All Airlines Before Cleanup");

        CleanUpAirlines();

        System.out.println(lstAllAirlines.size() + ": Size of All Airlines After Cleanup");

    }

    private static void CleanUpAirlines() {

    }

    private static List<Airline> ParseFileIntoAirlines(String sFile) {

        String DEFAULT_SEPARATOR = ",";
        List lstAirlines = new ArrayList<Airline>();

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(sFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNext()) {

            if (i==0) continue;

            String line = scanner.nextLine();
            String[] values = line.split(DEFAULT_SEPARATOR);

            String sCode = values[0];
            String sName = values[1];
            String sCountry = values[2];

            Airline al = new Airline(sCode, sName, sCountry);
            lstAirlines.add(al);

            i++;

        }

        scanner.close();
        return lstAirlines;
    }

    public static void PrintAllAirlines() {
    }
}
