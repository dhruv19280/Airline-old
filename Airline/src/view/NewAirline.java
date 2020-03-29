package Airline.src.view;

import Airline.src.init.AirlineInitializer;
import Airline.src.model.Airline;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

public class NewAirline extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList lstAirlines;
    private JLabel lblAirlineCode;
    private JLabel lblAirlineName;
    private JLabel lblAirlineCountry;

    public NewAirline() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        InitializeAirlineList(lstAirlines);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void InitializeAirlineList(JList airlineList) {

        airlineList.setAutoscrolls(true);
        airlineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        airlineList.setListData(AirlineInitializer.lstAllAirlines.toArray());

        airlineList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    final List<Airline> selectedValuesList = airlineList.getSelectedValuesList();
                    System.out.println(selectedValuesList);
                }
            }
        });
    }
}
