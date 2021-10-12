package output;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import compare.CompareFare;
import compare.CompareFareDuration;
import configuration.UtilityConfiguration;
import details.FlightDetails;
import input.UserInput;
import validation.Validation;

public class ResultFinder {
    Scanner scn = new Scanner(System.in);

    /*
     * Print a output in a given preference.
     */
    public void output(UserInput input) {
        try {

            Session session = new UtilityConfiguration().getSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            String departureLocation = input.getDeparturlocation();
            String arrivalLocation = input.getArrivallocation();
            String date = input.getDate();
            Query q = session.createQuery(
                    "from FlightDetails where departureLocation= :departure AND arrivalLocation= :arrival  ");
            q.setParameter("departure", departureLocation);
            q.setParameter("arrival", arrivalLocation);
            List<FlightDetails> list = q.list();
            if (list == null || list.size() <= 0) {
                System.out.println("No flight available");
                return;
            }
            System.out.println("Enter output prefrence(fare/fareduration):");
            String preference = scn.next();
            while (!new Validation().validateReference(preference)) {
                System.out.println("Enter valid output prefrence(fare/fareduration):");
                preference = scn.next();
            }
            if (preference.equalsIgnoreCase("fare"))
                new CompareFare().sort(list);
            else
                new CompareFareDuration().sort(list);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date userDate = sdf.parse(input.getDate());
            for (FlightDetails fl : list) {
                if (fl.getSeat_Availability().equals("Y") && fl.getFlightClass().contains(input.getFlightClass())
                        && userDate.compareTo(sdf.parse(fl.getFlightDate())) <= 0) {
                    if (input.getFlightClass().equals("E"))
                        printOutput(fl, 1.0, input.getDate());
                    else if (input.getFlightClass().equals("B"))
                        printOutput(fl, 1.4, input.getDate());
                }
            }

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void printOutput(FlightDetails fl, double factorOfBusinessClass, String date) {
        System.out.println("Flight Number: " + fl.getFlightNumber() + "\nFlight Duration: " + fl.getDuration() + " hrs"
                + "\nFlight Date: " + date + "\nFlight Fare: "
                + String.format("%.2f", (fl.getFare()) * factorOfBusinessClass) + "\n");

    }
}
