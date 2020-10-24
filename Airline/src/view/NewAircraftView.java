package Airline.src.view;

import Airline.src.init.AircraftModelsInitializer;
import Airline.src.model.AircraftModel;

import javax.swing.*;

public class NewAircraftView extends JPanel {
    public JPanel pnlNewAircraft;
    private JPanel pnlFilters;
    private JPanel pnlModels;
    private JPanel pnlDetails;
    private JComboBox cmbManufacturer;
    private JList lstModels;
    private JComboBox cmbAircraftType;
    private JComboBox cmbRangeType;
    private JComboBox cmbBodyType;
    private JComboBox cmbEngineType;

    public NewAircraftView() {
        PopulateFilterCombos();
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
        cmbManufacturer.addItem("---All---");
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
        cmbAircraftType.addItem("---All---");
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
        cmbRangeType.addItem("---All---");
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
        cmbBodyType.addItem("---All---");
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
        cmbEngineType.addItem("---All---");
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

}
