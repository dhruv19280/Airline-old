package Airline.src.view;

import Airline.src.init.AirlineGame;
import Airline.src.model.Aircraft;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel tabCapacity;

    public AircraftsView() {

        PopulateAircraftsList();

        lstOwnedAircrafts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                tabDetails.removeAll();
                tabDetails.add(AircraftDetailsPanel(lstOwnedAircrafts.getSelectedIndex()));

                tabCapacity.removeAll();
                tabCapacity.add(AircraftCapacitiesPanel(lstOwnedAircrafts.getSelectedIndex()));
            }
        });
        btnPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog dlg = new JDialog();
                dlg.setContentPane((new NewAircraftView()).pnlNewAircraft);
                dlg.setSize(300, 300);
                dlg.setTitle("Purchase Aircraft");
                dlg.pack();
                dlg.setVisible(true);

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
        JLabel lblAircraftType = new JLabel("Aircraft Type: " + a.sAircraftType);

        JLabel lblAircraftPurchased = new JLabel("Purchased: " + a.iPurchasedYear.toString() + " ( Age: " + a.iAge.toString() + " Years)");
        JLabel lblAircraftBodyType = new JLabel("Body Type: " + a.sBodyType);
        JLabel lblAircraftEngineType = new JLabel("Engine Type: " + a.sEngineType);
        JLabel lblAircraftRangeType = new JLabel("Range Type: " + a.sRangeType);

        JButton btnRenameAircraft = new JButton("Rename Aircraft...");
        JButton btnUpgradeAircraft = new JButton("Upgrade Aircraft...");
        JButton btnMaintainAircraft = new JButton("Maintain Aircraft...");
        JButton btnSellAircraft = new JButton("Sell Aircraft...");


        panel.add(lblAircraftName);
        panel.add(lblAircraftManufacturer);
        panel.add(lblAircraftModel);
        panel.add(lblAircraftType);

        panel.add(lblAircraftPurchased);
        panel.add(lblAircraftBodyType);
        panel.add(lblAircraftEngineType);
        panel.add(lblAircraftEngineType);
        panel.add(lblAircraftRangeType);

        panel.add(btnRenameAircraft);
        panel.add(btnUpgradeAircraft);
        panel.add(btnMaintainAircraft);
        panel.add(btnSellAircraft);

        SpringUtilities.makeGrid(panel,6, 2, 5, 5, 5, 5);

        return panel;
    }

    private JPanel AircraftCapacitiesPanel(Integer selectedAircraft) {
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        Aircraft a = AirlineGame.thisAirline.lstOwnedAircrafts.get(selectedAircraft);

        JLabel lblAircraftName = new JLabel("Name: " + a.sAircraftName);
        JLabel lblAircraftManufacturer = new JLabel("Manufacturer: " + a.sManufacturer);
        JLabel lblAircraftModel = new JLabel("Model: " + a.sAircraftModel);
        JLabel lblAircraftType = new JLabel("Aircraft Type: " + a.sAircraftType);

        JLabel lblAircraftEcoCapacity = new JLabel("Economy: " + a.iEconomyPassengerCapacity.toString() + " Passengers");
        JLabel lblAircraftBusCapacity = new JLabel("Business: " + a.iBusinessPassengerCapacity.toString() + " Passengers");
        JLabel lblAircraftFirCapacity = new JLabel("First: " + a.iFirstPassengerCapacity.toString() + " Passengers");
        JLabel lblAircraftCargoCapacity = new JLabel("Cargo: " + a.iCargoCapacity.toString() + " Units");
        JLabel lblAircraftFuelCapacity = new JLabel("Fuel: " + a.iFuelCapacity.toString() + " Units");
        JLabel lblAircraftCeiling = new JLabel("Ceiling: " + a.iEconomyPassengerCapacity.toString() + " Units");

        JButton btnUpgradeCargo = new JButton("Upgrade Cargo...");
        JButton btnUpgradeFuselage = new JButton("Upgrade Fuselage...");

        panel.add(lblAircraftName);
        panel.add(lblAircraftManufacturer);
        panel.add(lblAircraftModel);
        panel.add(lblAircraftType);

        panel.add(lblAircraftEcoCapacity);
        panel.add(lblAircraftBusCapacity);
        panel.add(lblAircraftFirCapacity);
        panel.add(lblAircraftCargoCapacity);
        panel.add(lblAircraftFuelCapacity);
        panel.add(lblAircraftCeiling);

        panel.add(btnUpgradeCargo);
        panel.add(btnUpgradeFuselage);

        SpringUtilities.makeGrid(panel,6, 2, 5, 5, 5, 5);

        return panel;
    }
}
