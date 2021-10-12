package assisgnments1;

import java.util.ArrayList;

public class Validation {
    enum type {
        Raw, Manufactured, Imported;
    }

    /**
     * this method is to check user input price or quantity is correct*
     * 
     * @param test
     * @return
     */
    public boolean isValidprice_quantity(String value) {
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (ch == '.')
                continue;
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method is to check user input type is correct*
     * 
     * @param test
     * @return
     */
    public boolean isValidType(String test) {
        for (type c : type.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    public boolean isVaid_argSize(ArrayList<String> args) {

        if (args.size() < 4 || args.size() > 4)
            return false;

        return true;
    }

}
