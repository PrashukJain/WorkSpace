package Details;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The InputReader program implements an application that simply reads and take
 * input from the user and create an item.
 *
 * @author Prashuk Jain
 */
public class InputReader {
    Scanner scn = new Scanner(System.in);
    private ArrayList<String> input;

    /**
     * this method calls different validation and also calls createItem for *
     * 
     * @param args
     * @return item object
     */
    public Item startReader(String[] args) {
        if (args != null)
            input = new ArrayList<>(Arrays.asList(args));
        else
            input = new ArrayList<>();
//validation
        if (input.size() != 0)
            validateInputs();
        else {
            takeinput();
        }
        return CreateItem();

    }

    /**
     * this method is used to validate inputs
     */
    private void validateInputs() {
//validate inputsize
        if (!new Validation().isValidArgSize(input)) {
            System.out.println("Please enter correct input");
            takeinput();
        }
        validateType(input.get(1)); // validation of type of item
        validatePrice(input.get(2));// validation of price of item
        validateQuantity(input.get(3));// validation of quantity of item

    }

    /**
     * this method is used to validate input type.
     */
    private void validateType(String type) {
        boolean isvalid = new Validation().isValidType(type); // index of type in arraylist is 1
        while (!isvalid) {
            System.out.println("Enter Item Type Correct:");
            type = scn.next();
            isvalid = new Validation().isValidType(type);
        }
        input.set(1, type);
    }

    /**
     * this method is used to validate input price
     */
    private void validatePrice(String price) {
        boolean isvalid = new Validation().isValidPriceQuantity(price);
        while (!isvalid) {
            System.out.println("Enter Item Price correct:");
            price = scn.next();
            isvalid = new Validation().isValidPriceQuantity(price);
        }
        input.set(2, price);
    }

    /**
     * this method is used to validate input quantity
     */
    private void validateQuantity(String quantity) {
        boolean isvalid = new Validation().isValidPriceQuantity(quantity);
        while (!isvalid) {
            System.out.println("Enter Item Quantity correct:");
            quantity = scn.next();
            isvalid = new Validation().isValidPriceQuantity(quantity);
        }
        input.set(3, quantity);
    }

    /**
     * this method is used for taking the input
     */
    private void takeinput() {

        System.out.println("Enter the name of item:");
        input.add(scn.next());
        System.out.println("Enter the type of item");
        input.add(scn.next());
        validateType(input.get(1));
        System.out.println("Enter the price of item");
        input.add(scn.next());
        validatePrice(input.get(2));
        System.out.println("Enter the quantity of item");
        input.add(scn.next());
        validateQuantity(input.get(3));
    }

    /**
     * this method is set the differnt parameters of item and return the item
     * object*
     * 
     * @return Item
     */
    private Item CreateItem() {
        Item item = new Item();
        item.setName(input.get(0));
        item.setType(ItemType.valueOf(input.get(1)));
        item.setPrice(input.get(2));
        item.setQuantity(input.get(3));
        return item;
    }

}
