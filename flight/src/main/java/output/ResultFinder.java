package output;

import java.util.LinkedList;
import java.util.Scanner;

import compare.CompareFare;
import compare.CompareFareDuration;
import details.FlightDetails;
import details.FlightVariables;
import validation.Validation;

public class ResultFinder {
    Scanner scn = new Scanner(System.in);

    /*
     * Print a output in a given preference.
     */
    public void output(input.UserInput input) {
        String key = input.getDepartureplusArrivalplusdate();
        String flightClass = input.getFlightClass();
        LinkedList<FlightDetails> list = null;
        if (FlightVariables.dataStorage.containsKey(key))
            list = FlightVariables.dataStorage.get(key);

        if (list == null) {
            System.out.println("No flight available");
            return;
        }
        if (flightClass.equalsIgnoreCase("B")) {
            LinkedList<FlightDetails> newlist = new LinkedList();
            for (FlightDetails detail : list) {
                if (detail.getFlightClass().equals("B") || detail.getFlightClass().equals("EB")) {
                    double fare = detail.getFare();
                    detail.setFare(Math.floor(fare * 1.4));
                    newlist.add(detail);
                }
            }
            list = newlist;
        }
        if (list == null) {
            System.out.println("No flight available for this class");
            return;
        }
        System.out.println("Enter output prefrence(fare/fareduration):");
        String preference = scn.next();
        while (!new Validation().validateReference(preference)) {
            System.out.println("Enter valid output prefrence(fare/fareduration):");
            preference = scn.next();
        }
        if (preference.equalsIgnoreCase("fare"))
            new CompareFare().sort(list);
        else
            new CompareFareDuration().sort(list);
        for (FlightDetails detail : list) {
            System.out.println(detail.toString());
        }
    }
}
