package Airline.src.view;

import Airline.src.model.GameTime;

import javax.swing.*;

public class MainView extends JPanel implements Runnable {

    public JPanel pnlMainView;
    private JPanel right;
    private JPanel top;
    private JPanel bottom;
    private JPanel center;
    private JTabbedPane tabbedPane1;
    private JTextArea txtLogs;
    private JPanel tabAirline;
    private JPanel tabAircrafts;
    private JPanel tabCrew;
    private JPanel tabRoutes;
    private JPanel tabFlights;
    private JPanel tabFinances;
    private JPanel tabMarketing;
    private JLabel lblTitle;
    private JLabel lblBottom;


    @Override
    public void run() {
        while(true) {
            lblBottom.setText(GameTime.GetGameCurrentTime());
        }
    }

    public MainView() {
        Thread thUpdateTime = new Thread(this);
        thUpdateTime.start();
    }
}
