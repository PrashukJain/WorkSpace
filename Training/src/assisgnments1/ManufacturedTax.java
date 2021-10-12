package assisgnments1;

public class ManufacturedTax implements taxcalculator {
    public double tax(double price) {
        double tax_12point5 = 12.5 / 100 * price;
        return tax_12point5 + 2.0 / 100 * (price + tax_12point5);
    }
}
