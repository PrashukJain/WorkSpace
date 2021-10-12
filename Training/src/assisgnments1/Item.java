package assisgnments1;

public class Item {

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public Double getTax() {
        return tax;
    }

    private String name;
    private String type;
    private String price;
    private String quantity;
    private Double tax;

    public Item(String name, String type, String price, String quantity, Double tax) {
        super();
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

}
