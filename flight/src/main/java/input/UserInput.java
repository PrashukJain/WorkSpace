package input;

public class UserInput {
    private String departureplusArrivalplusdate;
    private String flightClass;

    /*
     * Return a string of Departure location + Arrival location + flight date.
     */
    public String getDepartureplusArrivalplusdate() {
        return departureplusArrivalplusdate;
    }

    /*
     * Set a string of Departure location + Arrival location + flight date.
     */
    public void setDepartureplusArrivalplusdate(String departureplusArrivalplusdate) {
        this.departureplusArrivalplusdate = departureplusArrivalplusdate;
    }

    /*
     * Return a flight class.
     */
    public String getFlightClass() {
        return flightClass;
    }

    /*
     * Set a flight class.
     */
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

}
