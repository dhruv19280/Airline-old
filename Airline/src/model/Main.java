package Airline.src.model;

import Airline.src.init.AirlineGame;
import Airline.src.view.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        
        AirlineGame.Initialize();

        JFrame frame = new JFrame();
        frame.setSize(640, 480);
        frame.setTitle("Airline Manager v 1.0");
        frame.setContentPane(new MainView().pnlMainView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}