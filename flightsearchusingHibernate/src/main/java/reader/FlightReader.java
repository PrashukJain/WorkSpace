package reader;

import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;

import com.opencsv.CSVReader;

import configuration.UtilityConfiguration;
import details.FlightDetails;

public class FlightReader {
    public static void readFile() throws Exception {
        readFile1();
    }

    private static void readFile1() throws Exception {

        String[] nextLine;
        File directoryPath = new File("src\\main\\resources");
        File filesList[] = directoryPath.listFiles();

        Session session = new UtilityConfiguration().getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        session.createSQLQuery("Truncate TABLE FlightDetails").executeUpdate();
        tx.commit();
        tx = session.beginTransaction();
        for (File file : filesList) {
            CSVReader reader = new CSVReader(new FileReader(file.getAbsolutePath()));

            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                String[] arr = nextLine[0].split("\\|");
                FlightDetails flightObject = new FlightDetails();
                flightObject.setFlightNumber(arr[0]);
                flightObject.setDepartureLocation(arr[1]);
                flightObject.setArrivalLocation(arr[2]);
                flightObject.setFlightDate(arr[3]);
                flightObject.setFlightTime(arr[4]);
                flightObject.setDuration(Double.parseDouble(arr[5]));
                flightObject.setFare(Double.parseDouble(arr[6]));
                flightObject.setSeat_Availability(arr[7]);
                flightObject.setFlightClass(arr[8]);

                session.saveOrUpdate(flightObject);
            }

        }
        tx.commit();
    }
}
