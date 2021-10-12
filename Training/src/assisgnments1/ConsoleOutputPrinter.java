package assisgnments1;

public class ConsoleOutputPrinter {

    public String toString(Item item) {
        double finalPrice = Double.parseDouble(item.getPrice()) + item.getTax();

        return "Name :" + item.getName() + "\nPrice :" + item.getPrice() + "\nTax:" + item.getTax() + "\nfinal Price: "
                + finalPrice;
    }

}
