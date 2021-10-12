package details;

public class FlightDetails {

    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String flightDate;
    private String flightTime;
    private String seat_Availability;
    private double Duration;
    private double Fare;
    private String flightClass;

    /*
     * Returns the flight number of a flight
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the flightnumber
     * 
     * @param flightNumber
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Returns the departure location *
     * 
     * @return String
     */
    public String getDepartureLocation() {
        return departureLocation;
    }

    /**
     * Sets the departure location*
     * 
     * @param departureLocation
     */
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    /**
     * Returns the arrival location*
     * 
     * @return String
     */
    public String getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * Sets the arrival location*
     * 
     * @param arrivalLocation
     */
    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    /*
     * Returns the flight date.
     */
    public String getFlightDate() {
        return flightDate;
    }

    /*
     * Set the flight date
     */
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    /*
     * Returns the flightime
     */
    public String getFlightTime() {
        return flightTime;
    }

    /*
     * Set the flight time
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    /*
     * Returns the seat availability
     */
    public String getSeat_Availability() {
        return seat_Availability;
    }

    /*
     * Set the seat availability
     */
    public void setSeat_Availability(String seat_Availability) {
        this.seat_Availability = seat_Availability;
    }

    /*
     * Returns the flight duaration
     */
    public double getDuration() {
        return Duration;
    }

    /*
     * Set the flight duration.
     */
    public void setDuration(double duration) {
        Duration = duration;
    }

    /*
     * Return the flight fare.
     */
    public double getFare() {
        return Fare;
    }

    /*
     * Set the flight fare.
     */
    public void setFare(double fare) {
        Fare = fare;
    }

    /*
     * Return the flight class.
     */
    public String getFlightClass() {
        return flightClass;
    }

    /*
     * Set the flight class.
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String toString() {
        return this.getFlightNumber() + " " + this.getDepartureLocation() + " " + this.getArrivalLocation() + " "
                + this.getFare() + " " + this.getDuration() + " " + this.getFlightClass();
    }

}
