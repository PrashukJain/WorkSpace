package assisgnments1;

public class RawTax implements taxcalculator {

    @Override
    public double tax(double price) {

        return (12.5 * price) / 100;

    }

}
