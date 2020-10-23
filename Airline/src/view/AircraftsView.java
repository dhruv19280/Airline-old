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
    private JPanel tabDetails;

    public AircraftsView() {

        PopulateAircraftsList();

        lstOwnedAircrafts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                tabDetails.removeAll();
                tabDetails.add(AircraftDetailsPanel(lstOwnedAircrafts.getSelectedIndex()));
            }
        });
    }

    private void PopulateAircraftsList() {
        DefaultListModel aircraftModel = new DefaultListModel();
        aircraftModel.addAll(AirlineGame.thisAirline.GetAircraftsList());
        lstOwnedAircrafts.setModel(aircraftModel);
        lstOwnedAircrafts.updateUI();
    }

    private JPanel AircraftDetailsPanel(Integer selectedAircraft) {
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        Aircraft a = AirlineGame.thisAirline.lstOwnedAircrafts.get(selectedAircraft);

        JLabel lblAircraftName = new JLabel("Name: " + a.sAircraftName);
        JLabel lblAircraftManufacturer = new JLabel("Manufacturer: " + a.sManufacturer);
        JLabel lblAircraftModel = new JLabel("Model: " + a.sAircraftModel);
        JLabel lblAircraftPurchased = new JLabel("Purchased: " + a.iPurchasedYear.toString() + " ( Age: " + a.iAge.toString() + " Years)");

        JLabel lblAircraftType = new JLabel("Aircraft Type: " + a.sAircraftType);
        JLabel lblAircraftBodyType = new JLabel("Body Type: " + a.sBodyType);
        JLabel lblAircraftEngineType = new JLabel("Engine Type: " + a.sEngineType);
        JLabel lblAircraftRangeType = new JLabel("Range Type: " + a.sRangeType);


        panel.add(lblAircraftName);
        panel.add(lblAircraftManufacturer);
        panel.add(lblAircraftModel);
        panel.add(lblAircraftPurchased);
        panel.add(lblAircraftType);
        panel.add(lblAircraftBodyType);
        panel.add(lblAircraftEngineType);
        panel.add(lblAircraftEngineType);
        panel.add(lblAircraftRangeType);

        SpringUtilities.makeGrid(panel,4, 2, 5, 5, 5, 5);

        return panel;
    }
}
