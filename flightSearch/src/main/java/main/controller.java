package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import au.com.bytecode.opencsv.CSVReader;

public class controller {
	ArrayList<flightDetails> flightsearch;

	public controller() {
		flightsearch = new ArrayList();
	}

	public void readfile(String typeOfFlight, flightDetails inputObject) throws IOException {
		String path = "D:\\files\\" + typeOfFlight + ".csv";
		CSVReader reader = new CSVReader(new FileReader(path), ',', '"', 1);
	 
	  String[] nextLine; 
		ArrayList<String> arr = new ArrayList();
		int i = 1;
	  while((nextLine = reader.readNext()) != null) {;

			StringTokenizer token = new StringTokenizer(Arrays.toString(nextLine), "|");
			arr = new ArrayList();
			while (token.hasMoreTokens()) {
				arr.add(token.nextToken());
			}
			String flightclass=arr.get(8);
			flightDetails flight = new objectCreator().createObject(arr.get(1), arr.get(2), arr.get(3),
					flightclass.substring(0, flightclass.length() - 1));
//			System.out.println(arr.get(1) + " " + arr.get(2) + " " + arr.get(3) + " " + arr.get(8));
			if (flight.equals(inputObject)) {
				flight.setFare(Double.parseDouble(arr.get(6)));
				flight.setDuration(Double.parseDouble(arr.get(5)));
				flightsearch.add(flight);
		}

	}
}
public void typeofsort() {
	System.out.println("Enter the Output Preference(Fare/FlightDuration)");
//	new sortByFare().sort(flightsearch);
	new sortByDuration().sort(flightsearch);
}

public void printer() {
//	System.out.println(flightsearch.size());
	for (flightDetails fl : flightsearch) {
		System.out.println(fl.Fare + " " + fl.Duration);
	}
}

}
