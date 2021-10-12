package details;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class FlightDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String flightDate;
    private String flightTime;
    private String seat_Availability;
    @Column(length = 10, precision = 2)
    private double Duration;
    @Column(length = 10, precision = 2)
    private double Fare;
    private String flightClass;
    /*
     * This method used returns the duration of a flight
     */
    public double getDuration() {
        return Duration;
    }

    /*
     * This method is used to set the duration.
     */
    public void setDuration(double duration) {
        Duration = duration;
    }

    /*
     * This method used returns the Fare of a flight
     */
    public double getFare() {
        return Fare;
    }

    /*
     * This method is used to set the fare of flight.
     */
    public void setFare(double fare) {
        Fare = fare;
    }



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
        return "FlightDetails [flightNumber=" + flightNumber + ", departureLocation=" + departureLocation
                + ", arrivalLocation=" + arrivalLocation + ", flightDate=" + flightDate + ", flightTime=" + flightTime
                + ", seat_Availability=" + seat_Availability + ", Duration=" + Duration + ", Fare=" + Fare
                + ", flightClass=" + flightClass + "]";
    }


}
