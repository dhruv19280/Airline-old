package Airline.src.view;

import Airline.src.init.AirlineGame;
import Airline.src.model.Aircraft;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AircraftsView extends JPanel {

    public JPanel pnlAircraftsView;
    private JPanel left;
    private JPanel top;
    private JPanel center;
    private JList lstOwnedAircrafts;
    private JButton btnPurchase;
    private JTabbedPane tabAircraft;
    private JPanel tabRoute;
    private JPanel tabCrew;
    private JPanel tabFlights;
    private JPanel tabFinance;
    private JPanel tabRevenues;
    private JPanel tabCosts;
    private JPanel tabDetails;

    public AircraftsView() {

        PopulateAircraftsList();

        lstOwnedAircrafts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });
    }

    private void PopulateAircraftsList() {
        DefaultListModel aircraftModel = new DefaultListModel();
        aircraftModel.addAll(AirlineGame.thisAirline.GetAircraftsList());
        lstOwnedAircrafts.setModel(aircraftModel);
        lstOwnedAircrafts.updateUI();
    }
}
