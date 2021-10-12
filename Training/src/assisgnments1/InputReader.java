package assisgnments1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputReader {
    Scanner scn = new Scanner(System.in);
    private ArrayList<String> input;

    private enum type {

        Raw, Manufactured, Imported
    }

    public void startReader(String[] arg) {
        input = new ArrayList<>(Arrays.asList(arg));
//validation
        if (input.size() != 0)
            validate_inputs();
    else {
        takeinput();
    }
    Item item = CreateItem();

    // oututprint
    System.out.println(new ConsoleOutputPrinter().toString(item));


    }

    public void validate_inputs() {
//validate inputsize
        if (!new Validation().isVaid_argSize(input)) {
            System.out.println("Please enter correct input");
            takeinput();
        }
//validation of type of item
        boolean isvalid = new Validation().isValidType(input.get(1)); //index of type in arraylist is 1 
        while (!isvalid) {
            System.out.println("Enter Item Type Correct:");
            input.set(1, scn.next());
            isvalid = new Validation().isValidType(input.get(1));
        }

// validation of price of item
        isvalid = new Validation().isValidprice_quantity(input.get(2));
//      System.out.println(isvalid);
        while (!isvalid) {
            System.out.println("Enter Item Price correct:");
            input.set(2, scn.next());
            isvalid = new Validation().isValidprice_quantity(input.get(2));
            System.out.println(isvalid);
        }


//validation of quantity of item
        isvalid = new Validation().isValidprice_quantity(input.get(3));
        while (!isvalid) {
            System.out.println("Enter Item Quantity correct:");
            input.set(3, scn.next());
            isvalid = new Validation().isValidprice_quantity(input.get(3));
        }


    }

    public void takeinput() {
        input = new ArrayList<>();
        System.out.println("Enter the name of item:");
        input.add(scn.next());
        System.out.println(1);
        System.out.println("Enter the type of item");
        input.add(scn.next());
        System.out.println("type compelete");
        System.out.println("Enter the price of item");
        input.add(scn.next());
        System.out.println("Enter the quantity of item");
        input.add(scn.next());
        validate_inputs();

    }

    public Item CreateItem() {
        ItemDetail item = new ItemDetail();
        item.setName(input.get(0));
        item.setType(input.get(1));
        item.setPrice(input.get(2));
        item.setQuantity(input.get(3));
        String type=input.get(1),price=input.get(2);
        Double value;
//calculate tax
        switch (type) {
        case "Raw":
            value = Double.parseDouble(price);
            item.setTax(new RawTax().tax(value));
            break;
        case "Manufactured":
            value = Double.parseDouble(price);
            item.setTax(new ManufacturedTax().tax(value));
            break;
        case "Imported":
            value = Double.parseDouble(price);
            item.setTax(new ImportedTax().tax(value));
            break;
        }

        return item.getItem();
        // set item details;
        
    }

}
