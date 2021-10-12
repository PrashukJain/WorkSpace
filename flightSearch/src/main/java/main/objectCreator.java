package main;

import java.util.Scanner;

public class objectCreator {
	Scanner scn = new Scanner(System.in);



	public flightDetails takeInput() {
		System.out.println("Enter the Departure Location");
		String departureLocation = location(scn.next());

		System.out.println("Enter the arrival Location");
		String ArrivalLocation = location(scn.next());
		System.out.println("Enter the Date (Date format: DD-MM-YYYY");
		String FlightDate = scn.next();
		System.out.println("Enter the Class (E/B)");
		String FlightClass = scn.next();

		return createObject(departureLocation, ArrivalLocation, FlightDate, FlightClass);

	}

	public flightDetails createObject(String dept, String arr, String date, String flightclass) {
		flightDetails fd = new flightDetails();
		fd.setDepartureLocation(dept);
		fd.setArrivalLocation(arr);
		fd.setFlightDate(date);
		fd.setFlightClass(flightclass);
		return fd;
}

private String location(String depAndarrLoc) {
	switch (depAndarrLoc.toUpperCase()) {
	case "DELHI":
		return "DEL";

	case "MUMBAI":
		return "MUB";
	case "BANGALORE":
		return "BGR";

}
	return "";
}



}
