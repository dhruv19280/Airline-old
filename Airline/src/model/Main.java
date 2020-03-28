package Airline.src.model;

import Airline.src.init.AirlineGame;
import Airline.src.view.NewAirline;

public class Main {
    public static void main(String[] args) {
        
        AirlineGame.Initialize();
        NewAirline n = new NewAirline();
    }
}