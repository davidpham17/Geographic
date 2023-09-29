package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Country;

public class Library {
   
    private final Scanner sc = new Scanner(System.in);
    
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public float inputFloat() {
        while (true) {
            try {
                float result = Float.parseFloat(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public boolean inputYesNo() {
        while (true) {
            String result = inputString().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public boolean checkIdCoutryExist(ArrayList<Country> countries, String id) {
        for (Country c : countries) {
            if (c.getCountryCode().equalsIgnoreCase(id)) {
                System.err.println("Id exist!");
                return false;
            }
        }
        return true;
    }
    
    
  
}
