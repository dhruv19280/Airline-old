package Airline.src.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameTime extends Thread {

    public static Integer iGameStartYear = 1980;
    public static Integer iGameStartMonth = 1;
    public static Integer iGameStartDate = 1;
    public static Integer iGameStartHour = 0;
    public static Integer iGameStartMinutes=0;

    public static Integer iGameFinishYear = 2080;
    public static Integer iGameFinishMonth = 12;
    public static Integer iGameFinishDate = 31;
    public static Integer iGameFinishHour = 23;
    public static Integer iGameFinishMinutes=59;

    private static Long iVirtualMinsPerRealSecond = 15L;
    private static LocalDateTime dtGameCurrentTime;
    private static LocalDateTime dtGameStartDate;

    public GameTime() {
        dtGameStartDate =LocalDateTime.of(iGameStartYear, iGameStartMonth, iGameStartDate, iGameStartHour, iGameStartMinutes);
        dtGameCurrentTime =LocalDateTime.of(iGameStartYear, iGameStartMonth, iGameStartDate, iGameStartHour, iGameStartMinutes);
    }

    public static String GetGameCurrentTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
        String formatDateTime = dtGameCurrentTime.format(format);
        return formatDateTime;
    }

    private static void IncrementGameCurrentTime() {
        dtGameCurrentTime = dtGameCurrentTime.plusMinutes(iVirtualMinsPerRealSecond);
    } 

    @Override
    public void run() {
        while(true) {
            try {
                IncrementGameCurrentTime();
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
