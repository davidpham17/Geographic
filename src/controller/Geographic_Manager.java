package controller;

import common.Library;
import java.util.ArrayList;
import java.util.Collections;
import model.Country;
import view.Menu;

public class Geographic_Manager extends Menu<String>{
    static String[] mc = {"Enter the information for 11 countries in Southeast Asia.", 
        "Display already information.", "Search the country according to the entered country's name.", 
        "Display the information increasing with the country name." ,"Exit"};
    
    private Library library;
    ArrayList<Country> countries = new ArrayList<>();
    protected Country country;
    
    public Geographic_Manager(Country country) {
        super("GEOGRAPHIC MANAGEMENT PROGRAMMING", mc);
        library = new Library();
        this.country = country;
    }

    public void inputCountry(ArrayList<Country> countries) {
        while (true) {
        System.out.print("Enter code of contry: ");
        String countryCode = library.inputString();

        if (!library.checkIdCoutryExist(countries, countryCode)) {
            System.err.println("Country exist!");
            return;
        }
        System.out.print("Enter name of country: ");
        String countryName = library.inputString();
        System.out.print("Enter total area: ");
        float totalArea = library.inputFloat();
        System.out.print("Enter terrain of country: ");
        String countryTerrain = library.inputString();
        countries.add(new Country(countryCode, countryName, totalArea, countryTerrain));
        System.err.println("Add successful.");
        
        System.out.print("Do you want to create more country (Y/N): ");
            if (!library.inputYesNo()) {
                return;
            }
            
        }
    }
    
    public void printCountry(ArrayList<Country> countries) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country c : countries) {
            c.display();
        }
    }
    
    public void printCountrySorted(ArrayList<Country> countries) {
        Collections.sort(countries);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : countries) {
            country.display();
        }
    }

    public void searchByName(ArrayList<Country> countries) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = library.inputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : countries) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                inputCountry(countries);
                break;
            case 2:
                printCountry(countries);
                break;
            case 3:
                searchByName(countries);
                break;
            case 4:
                printCountrySorted(countries);
                break;
            case 5:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }   
    

}