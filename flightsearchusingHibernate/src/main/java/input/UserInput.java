package input;

public class UserInput {
    private String departurlocation;
    private String arrivallocation;
    private String date;
    private String flightClass;

    public String getDeparturlocation() {
        return departurlocation;
    }

    public void setDeparturlocation(String departurlocation) {
        this.departurlocation = departurlocation;
    }

    public String getArrivallocation() {
        return arrivallocation;
    }

    public void setArrivallocation(String Arrivallocation) {
        arrivallocation = Arrivallocation;
    }

    public String getDate() {
        return date;
    }

    /*
     * Set a date of flight
     */
    public void setDate(String Date) {
        date = Date;
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
