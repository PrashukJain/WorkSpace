package Details;

import CalculationTax.ImportedTax;
import CalculationTax.ManufacturedTax;
import CalculationTax.RawTax;
import CalculationTax.TaxCalculator;

public class TaxCalculation {
    /**
     * this method set the tax and final price of different type of item*
     * 
     * @param item
     */
    public void typeTax(Item item) {
        Double value = 0.0;
        TaxCalculator itemTax = null;
        switch (item.getType()) {
        case RAW:
            value = Double.parseDouble(item.getPrice());
            itemTax = new RawTax();
            break;
        case MANUFACTURED:
            value = Double.parseDouble(item.getPrice());
            itemTax = new ManufacturedTax();
            break;
        case IMPORTED:
            value = Double.parseDouble(item.getPrice());
            itemTax = new ImportedTax();
            break;
        }
        double taxPerItem = itemTax.tax(value);
        double quantity = Double.parseDouble(item.getQuantity());
        double finalPricewithTax = quantity * (value + taxPerItem);
        item.setTax(taxPerItem);
        item.setFinalPrice(finalPricewithTax);

    }
}
