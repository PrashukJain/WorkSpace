package CalculationTax;

public class ManufacturedTax implements TaxCalculator {
    /**
     * this method returns the Manufactured tax
     */
    public double tax(double price) {
        double tax_12point5 = 12.5 / 100 * price;
        return tax_12point5 + 2.0 / 100 * (price + tax_12point5);
    }
}
