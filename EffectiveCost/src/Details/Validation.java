package Details;

import java.util.ArrayList;

public class Validation {

    /**
     * this method is to check user input price or quantity is correct*
     * 
     * @param test
     * @return
     */
    public boolean isValidPriceQuantity(String value) {

        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * this method is to check user input type is correct*
     * 
     * @param type
     * @return
     */
    public boolean isValidType(String type) {
        for (ItemType c : ItemType.values()) {
            if (c.name().equals(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method is check the args required length*
     * 
     * @param args
     * @return
     */
    public boolean isValidArgSize(ArrayList<String> args) {

        if (args.size() < 4 || args.size() > 4)
            return false;

        return true;
    }

}
