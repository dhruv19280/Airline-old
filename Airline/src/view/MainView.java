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
    private JTabbedPane tabTop;
    private JPanel tabAirline;
    private JPanel tabAircrafts;
    private JPanel tabCrew;
    private JPanel tabRoutes;
    private JPanel tabFlights;
    private JPanel tabFinances;
    private JPanel tabMarketing;
    private JPanel tabLogs;
    private JLabel lblTitle;
    private JLabel lblBottom;
    private JLabel lblFunds;
    private JLabel lblValue;
    private JLabel lblAirline;


    @Override
    public void run() {
        while(true) {
            lblBottom.setText(GameTime.GetGameCurrentTime());
            lblFunds.setText(AirlineGame.thisAirline.getAirlineFunds());
            lblValue.setText(AirlineGame.thisAirline.getAirlineValue());
            lblAirline.setText(AirlineGame.thisAirline.getAirlineName() + " - " + AirlineGame.thisAirline.getAirlineBase());
        }
    }

    public MainView() {
        Thread thUpdateTime = new Thread(this);
        thUpdateTime.start();

        InitializeAircraftsTab();
    }

    public void InitializeAircraftsTab() {
        tabAircrafts.add(new AircraftsView().pnlAircraftsView);
    }
}
