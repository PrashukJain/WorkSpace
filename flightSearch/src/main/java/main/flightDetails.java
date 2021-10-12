package main;

public class flightDetails {
	String departureLocation;
	String arrivalLocation;
	String flightDate;
	String flightClass;
	double Duration;
	double Fare;

	public double getDuration() {
		return Duration;
	}

	public void setDuration(double duration) {
		Duration = duration;
	}

	public double getFare() {
		return Fare;
	}

	public void setFare(double fare) {
		Fare = fare;
	}


	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		// checking for two condition:
		// 1) object is pointing to null
		// 2) if the objects belong to
		// same class or not
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		flightDetails fd = (flightDetails) obj; // type casting object to the
							// intended class type

		// checking if the two two
		// objects share all the same values
		return this.departureLocation.equals(fd.departureLocation) && this.arrivalLocation.equals(arrivalLocation)
				&& this.flightDate.equals(fd.flightDate) && this.flightClass.equals(fd.flightClass);
	}

}
