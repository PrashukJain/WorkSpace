package CalculationTax;

public class RawTax implements TaxCalculator {
    /**
     * this method returns the raw tax
     */
    public double tax(double price) {

        return (12.5 * price) / 100;

    }

}
