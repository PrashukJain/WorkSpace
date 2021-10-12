
package details;

import java.util.HashMap;
import java.util.LinkedList;

public class FlightVariables {

    public static HashMap<String, LinkedList<FlightDetails>> dataStorage = new HashMap();

    public static void reInitialize() {
        dataStorage = new HashMap();
    }

}
