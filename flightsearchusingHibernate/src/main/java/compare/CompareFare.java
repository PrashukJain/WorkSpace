package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import details.FlightDetails;

public class CompareFare {
    /*
     * Sorts specified list according to fare of a flight
     */
    public void sort(List<FlightDetails> myList) {
        Collections.sort(myList, new Comparator<FlightDetails>() {
            public int compare(FlightDetails f1, FlightDetails f2) {
                Double fare1 = f1.getFare();
                Double fare2 = f2.getFare();
                return Double.compare(fare1, fare2);
            }
        });
    }
}
