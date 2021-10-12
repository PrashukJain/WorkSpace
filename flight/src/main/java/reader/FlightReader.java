package reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import au.com.bytecode.opencsv.CSVReader;
import details.FlightDetails;
import details.FlightVariables;


public class FlightReader {
    public static void readDirectory() throws IOException {
        File directoryPath = new File("src\\main\\resources");
        File filesList[] = directoryPath.listFiles();
        for (File file : filesList) {
            readfile(file.getAbsolutePath());
        }
    }

    public static void readfile(String path) throws IOException {

        CSVReader reader = new CSVReader(new FileReader(path), ',', '"', 1);

        String[] nextLine;
        ArrayList<String> arr = new ArrayList();
        Configuration con = new Configuration().configure().addAnnotatedClass(FlightDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        while ((nextLine = reader.readNext()) != null) {


            StringTokenizer token = new StringTokenizer(Arrays.toString(nextLine), "|");
            arr = new ArrayList();
            while (token.hasMoreTokens()) {
                arr.add(token.nextToken());
            }
            if (arr.get(7).equals("Y")) {
                String flightclass = arr.get(8);
                flightclass = flightclass.substring(0, flightclass.length() - 1);
                String key = arr.get(1) + arr.get(2) + arr.get(3);
                FlightDetails flightObject = new FlightDetails();
                // set variables of a object
                flightObject.setFlightNumber(arr.get(0).substring(1));
                flightObject.setDepartureLocation(arr.get(1));
                flightObject.setArrivalLocation(arr.get(2));
                flightObject.setFlightDate(arr.get(3));
                flightObject.setFlightTime(arr.get(4));
                flightObject.setDuration(Double.parseDouble(arr.get(5)));
                flightObject.setFare(Double.parseDouble(arr.get(6)));
                flightObject.setSeat_Availability(arr.get(7));
                flightObject.setFlightClass(flightclass);


                if (FlightVariables.dataStorage.containsKey(key)) {
                    LinkedList<FlightDetails> list = FlightVariables.dataStorage.get(key);
                    list.add(flightObject);
                    FlightVariables.dataStorage.put(key, list);
                } else {

                    LinkedList<FlightDetails> list = new LinkedList();
                    list.add(flightObject);
                    FlightVariables.dataStorage.put(key, list);
                }
            }
        }

    }
}
