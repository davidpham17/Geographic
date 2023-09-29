package main;

import controller.Geographic_Manager;
import model.Country;

public class Main {

    public static void main(String[] args) {
        Country c = new Country();
        
        new Geographic_Manager(c).run();
    }
    
}
