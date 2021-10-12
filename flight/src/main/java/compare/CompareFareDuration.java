package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import details.FlightDetails;

public class CompareFareDuration {
    /*
     * Sorts the specified list
     */
    public void sort(LinkedList<FlightDetails> myList) {
        Collections.sort(myList, new Comparator<FlightDetails>() {
            public int compare(FlightDetails f1, FlightDetails f2) {
                int fare = (int) (f1.getFare() - f2.getFare());



                if (fare == 0) {
                    return Double.compare(f1.getDuration(), f2.getDuration());
                } else {
                    return fare;
                }
            }
        });
    }
}
