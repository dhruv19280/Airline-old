package Airline.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameTime {

    private static Integer iGameStartYear = 1980;
    private static Integer iGameStartMonth = 1;
    private static Integer iGameStartDate = 1;
    private static Integer iGameStartHour = 6;
    private static Integer iGameStartMinutes=0;

    private static Long iVirtualMinsPerRealSecond = 15L;
    private static LocalDateTime dtGameCurrentTime;
    private static LocalDateTime dtGameStartDate;

    GameTime() {
        dtGameStartDate =LocalDateTime.of(iGameStartYear, iGameStartMonth, iGameStartDate, iGameStartHour, iGameStartMinutes);
        dtGameCurrentTime =LocalDateTime.of(iGameStartYear, iGameStartMonth, iGameStartDate, iGameStartHour, iGameStartMinutes);
    }

    public static String GetGameCurrentTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm tt");
        String formatDateTime = dtGameCurrentTime.format(format);
        return formatDateTime;
    }

    public static void IncrementGameCurrentTime() {
        dtGameCurrentTime = dtGameCurrentTime.plusMinutes(iVirtualMinsPerRealSecond);
    }
}
