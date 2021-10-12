package reader;

import java.util.Scanner;

import input.UserInput;
import validation.Validation;

public class InputReader {
    Scanner scn = new Scanner(System.in);

    /*
     * By using this function user can input departure location and arrival location.
     */
    public UserInput takeInput() {
        input.UserInput input = new UserInput();
        System.out.println("Enter the Departure Location");
        String departureLocation = takeLocation();
        System.out.println("Enter the arrival Location");
        String ArrivalLocation = takeLocation();
        String flightDate = takeFlightDate();
        input.setDepartureplusArrivalplusdate(departureLocation + ArrivalLocation + flightDate);
        input.setFlightClass(takeFlightClass());
        return input;

    }

    private String takeLocation() {
        String location = scn.next();
        while (!new Validation().validateLocation(location)) {
            System.out.println("Enter valid Location");
            location = scn.next();
        }
        return location.toUpperCase();
    }

    private String takeFlightDate() {
        System.out.println("Enter the Date (Date format: DD-MM-YYYY)");
        String flightDate = scn.next();
        while (!new Validation().validateDate(flightDate)) {
            flightDate = scn.next();
        }
        return flightDate;
    }

    private String takeFlightClass() {
        System.out.println("Enter the Class (E/B)");
        String flightClass = scn.next();
        while (!(new Validation().validateFlightClass(flightClass))) {
            System.out.println("Please enter the correct Class (E/B)");
            flightClass = scn.next();
        }
        return flightClass;
    }



}
