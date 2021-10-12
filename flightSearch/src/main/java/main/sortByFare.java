package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortByFare {
	public void sort(ArrayList<flightDetails> myList) {
		Collections.sort(myList, new Comparator<flightDetails>() {
			@Override
			public int compare(flightDetails c1, flightDetails c2) {
				return Double.compare(c1.getFare(), c2.getFare());
			}
		});
	}


}
