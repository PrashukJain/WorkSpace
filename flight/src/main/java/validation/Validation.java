package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Validation {
    /**
     * This method is used to validate the user input flight class.*
     * 
     * @param input
     * @return
     */
    public boolean validateFlightClass(String input) {
        input = input.toUpperCase();
        if (input.equals("E") || input.equals("B"))
            return true;
        return false;
    }
    /*
     * This method is used to validate the user input flight departure location and arrival location.
     */

    public boolean validateLocation(String s) {
        if (s.length() == 3) {
            return true;
        }
        return false;

    }

    /*
     * This method is used to validate the user input of output Reference.
     */
    public boolean validateReference(String s) {
        if (s.equalsIgnoreCase("fare") || s.equalsIgnoreCase("fareduration")) {
            return true;
        }
        return false;
    }

    /*
     * This method is used to validate the user input flight date.
     */
    public boolean validateDate(String flightDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dat = sdf.parse(flightDate);
            if (!flightDate.equals(sdf.format(dat))) {
                throw new ParseException("", 1);
            }
            String[] date = flightDate.split("\\-");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            LocalDate.of(year, month, day);
        } catch (ParseException pe) {
            System.out.println("Please enter Date in format DD-MM-YYYY");
            return false;
        } catch (Exception e) {
            System.out.println("Entered Date is Invalid");
            return false;
        }
        return true;
    }

}
