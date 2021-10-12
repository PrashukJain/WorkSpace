package CalculationTax;

public class ImportedTax implements TaxCalculator {
    /**
     * this method return the imported tax
     */
    public double tax(double price) {
        double tax_init = 10.0 / 100 * price;
        if (tax_init <= 100)
            return tax_init + 5;
        else if (tax_init > 100 && tax_init <= 200)
            return tax_init + 10;
        else
            return 5.0 / 100 * (tax_init + price);
    }

}
