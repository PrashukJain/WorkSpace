package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import details.FlightDetails;

public class CompareFare {
    /*
     * Sorts specified list according to fare of a flight
     */
    public void sort(LinkedList<FlightDetails> myList) {
        Collections.sort(myList, new Comparator<FlightDetails>() {
            public int compare(FlightDetails f1, FlightDetails f2) {
                return Double.compare(f1.getFare(), f2.getFare());
            }
        });
    }
}
