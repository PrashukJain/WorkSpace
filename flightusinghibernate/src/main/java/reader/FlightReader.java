package reader;

import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;

import com.opencsv.CSVReader;

import configuration.Utilityconfiguration;
import details.FlightDetails;

public class FlightReader {
    public static void readfile() throws Exception {
        File directoryPath = new File("src\\main\\resources");
        File filesList[] = directoryPath.listFiles();
        Session session = new Utilityconfiguration().getConfiguration();
        org.hibernate.Transaction tx = session.beginTransaction();
        for (File file : filesList) {
            CSVReader reader = new CSVReader(new FileReader(file.getAbsolutePath()));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                String[] arr = nextLine[0].split("\\|");
                String hash = arr[1] + arr[2] + arr[3];
                FlightDetails flightObject = new FlightDetails();
                flightObject.setFlightNumber(arr[0]);
                flightObject.setDepartureLocation(arr[1]);
                flightObject.setArrivalLocation(arr[2]);
                flightObject.setFlightDate(arr[3]);
                flightObject.setFlightTime(arr[4]);
                flightObject.setDuration(Double.parseDouble(arr[5]));
                flightObject.setFare(Double.parseDouble(arr[6]));
                flightObject.setSeatAvailability(arr[7]);
                // flightObject.setFlightNumberplusDate(arr[0] + arr[3]);
                flightObject.setFlightClass(arr[8]);
                session.save(flightObject);
            }
        }
        tx.commit();
    }
}
