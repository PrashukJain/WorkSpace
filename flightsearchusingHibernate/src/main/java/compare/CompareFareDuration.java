package compare;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import details.FlightDetails;

public class CompareFareDuration {
    /*
     * Sorts the specified list
     */
    public void sort(List<FlightDetails> myList) {
        Collections.sort(myList, new Comparator<FlightDetails>() {
            public int compare(FlightDetails f1, FlightDetails f2) {
                Double fare1 = f1.getFare();
                Double fare2 = f2.getFare();
                int fare = (int) (fare1 - fare2);
                Double duration1 = f1.getDuration();
                Double duration2 = f2.getDuration();

                if (fare == 0) {
                    return Double.compare(duration1, duration2);
                } else {
                    return fare;
                }
            }
        });
    }
}
