package Airline.src.view;

import Airline.src.init.AircraftModelsInitializer;
import Airline.src.model.AircraftModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewAircraftView extends JPanel {

    public JPanel pnlNewAircraft;
    private JPanel pnlFilters;
    private JPanel pnlModels;
    private JPanel pnlFilterScroll;
    private JPanel pnlModelDetails;
    private JPanel pnlActions;
    private JPanel pnlActionsScroll;
    private JPanel pnlCapacities;
    private JPanel pnlOtherDetails;
    private JPanel pnlModelDet;
    private JPanel pnlCrew;
    private JPanel pnlAvailability;

    private JComboBox cmbManufacturer;
    private JComboBox cmbAircraftType;
    private JComboBox cmbRangeType;
    private JComboBox cmbBodyType;
    private JComboBox cmbEngineType;
    private JList lstModels;

    private JScrollPane scrFilterScroll;
    private JButton btnPurchase;
    private JButton btnCustomize;
    private JButton btnCancel;
    private JButton btnLeaseAircraft;

    private JLabel lblSearch;
    private JLabel lblSearchResult;
    private JLabel lblModel;
    private JLabel lblAircraftType;
    private JLabel lblBodyType;
    private JLabel lblRangeType;
    private JLabel lblEngineType;
    private JLabel lblLength;
    private JLabel lblMaxPassengers;
    private JLabel lblMaxCargo;
    private JLabel lblMaxFuel;
    private JLabel lblWingspan;
    private JLabel lblPrice;
    private JLabel lblMaxRange;
    private JLabel lblMaxSpeed;
    private JLabel lblFuelConsumption;
    private JLabel lblWearRate;
    private JLabel lblMinRunway;
    private JLabel lblCockpitCrew;
    private JLabel lblCabinCrew;
    private JLabel lblMaxClasses;
    private JLabel lblAvailableFrom;
    private JLabel lblAvailableTill;



    public NewAircraftView() {
        pnlFilters.setLayout(new BoxLayout(pnlFilters, BoxLayout.LINE_AXIS));
        pnlFilterScroll.setLayout(new BoxLayout(pnlFilterScroll, BoxLayout.LINE_AXIS));
        pnlActions.setLayout(new BoxLayout(pnlActions, BoxLayout.LINE_AXIS));
        pnlActionsScroll.setLayout(new BoxLayout(pnlActionsScroll, BoxLayout.LINE_AXIS));


        pnlModelDetails.setLayout(new BoxLayout(pnlModelDetails, BoxLayout.PAGE_AXIS));
        pnlCapacities.setLayout(new BoxLayout(pnlCapacities, BoxLayout.PAGE_AXIS));
        pnlOtherDetails.setLayout(new BoxLayout(pnlOtherDetails, BoxLayout.PAGE_AXIS));
        pnlModelDet.setLayout(new BoxLayout(pnlModelDet, BoxLayout.PAGE_AXIS));
        pnlCrew.setLayout(new BoxLayout(pnlCrew, BoxLayout.PAGE_AXIS));
        pnlAvailability.setLayout(new BoxLayout(pnlAvailability, BoxLayout.PAGE_AXIS));


        PopulateFilterCombos();
        FilterAndPopulateModelList();

        cmbManufacturer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                FilterAndPopulateModelList();
            }
        });

        cmbEngineType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                FilterAndPopulateModelList();
            }
        });

        cmbRangeType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                FilterAndPopulateModelList();
            }
        });

        cmbAircraftType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                FilterAndPopulateModelList();
            }
        });

        cmbBodyType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                FilterAndPopulateModelList();
            }
        });
        lstModels.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(listSelectionEvent.getFirstIndex()>=0) {
                    PopulateModelDetails();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void PopulateFilterCombos() {
        PopulateManufacturerCombo();
        PopulateAircraftTypeCombo();
        PopulateRangeTypeCombo();
        PopulateBodyTypeCombo();
        PopulateEngineTypeCombo();
    }

    private void PopulateManufacturerCombo() {
        cmbManufacturer.removeAllItems();
        cmbManufacturer.addItem("---Manufacturer---");
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean found = false;
            for (int i = 0; i<cmbManufacturer.getItemCount(); i++) {
                if (cmbManufacturer.getItemAt(i).toString().equals(m.sManufacturer)) {
                    found = true;
                }
            }
            if (found==false) {
                cmbManufacturer.addItem(m.sManufacturer);
            }
        }
    }

    private void PopulateAircraftTypeCombo() {
        cmbAircraftType.removeAllItems();
        cmbAircraftType.addItem("---Aircraft Type---");
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean found = false;
            for (int i = 0; i<cmbAircraftType.getItemCount(); i++) {
                if (cmbAircraftType.getItemAt(i).toString().equals(m.sAircraftType)) {
                    found = true;
                }
            }
            if (found==false) {
                cmbAircraftType.addItem(m.sAircraftType);
            }
        }
    }

    private void PopulateRangeTypeCombo() {
        cmbRangeType.removeAllItems();
        cmbRangeType.addItem("---Range---");
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean found = false;
            for (int i = 0; i<cmbRangeType.getItemCount(); i++) {
                if (cmbRangeType.getItemAt(i).toString().equals(m.sRangeType)) {
                    found = true;
                }
            }
            if (found==false) {
                cmbRangeType.addItem(m.sRangeType);
            }
        }
    }

    private void PopulateBodyTypeCombo() {
        cmbBodyType.removeAllItems();
        cmbBodyType.addItem("---Body Type---");
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean found = false;
            for (int i = 0; i<cmbBodyType.getItemCount(); i++) {
                if (cmbBodyType.getItemAt(i).toString().equals(m.sBodyType)) {
                    found = true;
                }
            }
            if (found==false) {
                cmbBodyType.addItem(m.sBodyType);
            }
        }
    }

    private void PopulateEngineTypeCombo() {
        cmbEngineType.removeAllItems();
        cmbEngineType.addItem("---Engine Type---");
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean found = false;
            for (int i = 0; i<cmbEngineType.getItemCount(); i++) {
                if (cmbEngineType.getItemAt(i).toString().equals(m.sEngineType)) {
                    found = true;
                }
            }
            if (found==false) {
                cmbEngineType.addItem(m.sEngineType);
            }
        }
    }

    private void FilterAndPopulateModelList() {
        String sFilterManufacturer;
        String sFilterBodyType;
        String sFilterAircraftType;
        String sFilterEngineType;
        String sFilterRangeType;

        sFilterManufacturer = cmbManufacturer.getSelectedItem().toString();
        sFilterBodyType = cmbBodyType.getSelectedItem().toString();
        sFilterAircraftType = cmbAircraftType.getSelectedItem().toString();
        sFilterRangeType = cmbRangeType.getSelectedItem().toString();
        sFilterEngineType = cmbEngineType.getSelectedItem().toString();

        System.out.println(sFilterAircraftType + " : " + sFilterBodyType + " : " + sFilterEngineType + " : " + sFilterManufacturer + " : " + sFilterRangeType);

        DefaultListModel lstModelAircraft = new DefaultListModel();
        lstModelAircraft.clear();
        for(AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            boolean toAdd = true;
            if(!sFilterAircraftType.equals("---Aircraft Type---")) {
                if(!sFilterAircraftType.equals(m.sAircraftType)) {
                    toAdd = false;
                }
            }
            if(!sFilterBodyType.equals("---Body Type---")) {
                if (!sFilterBodyType.equals(m.sBodyType)) {
                    toAdd = false;
                }
            }
            if(!sFilterEngineType.equals("---Engine Type---")) {
                if (!sFilterEngineType.equals(m.sEngineType)) {
                    toAdd = false;
                }
            }
            if(!sFilterManufacturer.equals("---Manufacturer---")) {
                if (!sFilterManufacturer.equals(m.sManufacturer)) {
                    toAdd = false;
                }
            }
            if(!sFilterRangeType.equals("---Range---")) {
                if (!sFilterRangeType.equals(m.sRangeType)) {
                    toAdd = false;
                }
            }
            if(toAdd) {
                lstModelAircraft.addElement(m.sAircraftModel);
            }

        }
        lstModels.setModel(lstModelAircraft);

        if(lstModels.getModel().getSize() > 0 && lstModels.getSelectedIndex() < 0) {
            lstModels.setSelectedIndex(0);
        }
    }

    private void PopulateModelDetails() {

        if(lstModels.getModel().getSize() > 0 && lstModels.getSelectedIndex() < 0) {
            lstModels.setSelectedIndex(0);
        }

        Integer i = lstModels.getSelectedIndex();
        Object o = lstModels.getModel().getElementAt(i);
        String s = o.toString();

        AircraftModel aSelectedModel = null;
        for (AircraftModel m : AircraftModelsInitializer.lstAllAircraftModels) {
            if(s.equals(m.sAircraftModel)) {
                aSelectedModel = m;
                break;
            }
        }

        lblModel.setText("Model Name: " + aSelectedModel.sAircraftModel);
        lblAircraftType.setText("Aircraft Type: " + aSelectedModel.sAircraftType);
        lblBodyType.setText("Body Type: " + aSelectedModel.sBodyType);
        lblRangeType.setText("Range Classification: " + aSelectedModel.sRangeType);
        lblEngineType.setText("Engine Class: " + aSelectedModel.sEngineType);
        lblPrice.setText("Base Price: " + aSelectedModel.dBasePrice.toString());

        lblMaxPassengers.setText("Max Passengers: " + aSelectedModel.iMaxEconomyCapacity.toString() + " Passengers");
        lblMaxCargo.setText("Max Cargo Capacity: " + aSelectedModel.fMaxCargoCapacity.toString() + " Units");
        lblMaxFuel.setText("Fuel Capacity: " + aSelectedModel.iFuelCapacity + " liters");
        lblMaxRange.setText("Max Range: " + aSelectedModel.iMaximumRange + " kms");
        lblMaxSpeed.setText("Max Speed: " + aSelectedModel.iMaxSpeedPerHour + " km/hr");
        lblMaxClasses.setText("Max Classes: " + aSelectedModel.iMaxClasses);

        lblAvailableFrom.setText("Available From: " + aSelectedModel.dtManufacturedFrom.getYear());
        lblAvailableTill.setText("Available Till: " + aSelectedModel.dtManufacturedTo.getYear());

        lblCockpitCrew.setText("Min Cockpit Crew: " + aSelectedModel.iMinCockpitCrew + " Pilots");
        lblCabinCrew.setText("Min Cabin Crew: " + aSelectedModel.iMinCabinCrew + " Hosts");

        lblLength.setText("Length: " + aSelectedModel.fLength + " m");
        lblWingspan.setText("Wingspan: " + aSelectedModel.fWingspan + " m");
        lblFuelConsumption.setText("Fuel Consumption: " + aSelectedModel.fFuelConsumption.toString() + " liters / km");
        lblWearRate.setText("Wear Rate: " + aSelectedModel.fBaseWearRate + " % wear per 100000 kms flown");
        lblMinRunway.setText("Min Runway Length: " + aSelectedModel.iMinTakeOffDistance + " m");


    }
}
