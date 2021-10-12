package Output;

import Details.Item;

public class ConsoleOutputPrinter {
    /**
     * this method is useo print the item object*
     * 
     * @param item
     */
    public void toString(Item item) {
        System.out.println("Name :" + item.getName() + "\nPrice :" + item.getPrice() + "\nTax:" + item.getTax()
                + "\nfinal Price: " + item.getFinalPrice());
    }

}
