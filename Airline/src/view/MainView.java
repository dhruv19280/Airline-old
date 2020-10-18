package Airline.src.view;

import Airline.src.init.AirlineGame;
import Airline.src.model.Airline;
import Airline.src.model.GameTime;

import javax.swing.*;

public class MainView extends JPanel implements Runnable {

    public JPanel pnlMainView;
    private JPanel top;
    private JPanel bottom;
    private JPanel center;
    private JTabbedPane tabbedPane1;
    private JPanel tabAirline;
    private JPanel tabAircrafts;
    private JPanel tabCrew;
    private JPanel tabRoutes;
    private JPanel tabFlights;
    private JPanel tabFinances;
    private JPanel tabMarketing;
    private JLabel lblTitle;
    private JLabel lblBottom;
    private JPanel tabLogs;
    private JLabel lblFunds;
    private JLabel lblValue;


    @Override
    public void run() {
        while(true) {
            lblBottom.setText(GameTime.GetGameCurrentTime());
            lblFunds.setText(AirlineGame.thisAirline.getAirlineFunds());
            lblValue.setText(AirlineGame.thisAirline.getAirlineValue());
        }
    }

    public MainView() {
        Thread thUpdateTime = new Thread(this);
        thUpdateTime.start();
    }
}
