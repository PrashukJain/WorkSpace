package assisgnments1;

public class ItemDetail {
    private String name;
    private String type;
    private String price;
    private String quantity;
    private Double tax;
//    Scanner scn = new Scanner(System.in);
//
//    public ItemDetail() {
//        setName();
//        setType();
//        setPrice();
//        setQuantity();
//        setTax();
//    }
//
//    public String getName() {
//        return name;
//    }

//
//    /**
//     * set name of item
//     */
//    public void setName() {
//        System.out.println("Enter Item Name:");
//        this.name = scn.next();
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    /**
//     * set type of item
//     */
//    public void setType() {
//        System.out.println("Enter Item Type:");
//        this.type = scn.next();
//        boolean isvalid = new Validation().isValidType(type);
//        while (!isvalid) {
//            System.out.println("Enter Item Type Correct:");
//            this.type = scn.next();
//            isvalid = new Validation().isValidType(type);
//        }
//
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    /**
//     * set price of item
//     */
//
//    public void setPrice() {
//        System.out.println("Enter Item Price:");
//        this.price = scn.next();
//        boolean isvalid = new Validation().isValidprice_quantity(price);
//        System.out.println(isvalid);
//        while (!isvalid) {
//            System.out.println("Enter Item Price correct:");
//            this.price = scn.next();
//            isvalid = new Validation().isValidprice_quantity(price);
//            System.out.println(isvalid);
//        }
//
//    }
//
//    public String getQuantity() {
//        return quantity;
//    }
//
//    /**
//     * set quantity of item
//     */
//    public void setQuantity() {
//        System.out.println("Enter Item Quantity:");
//        this.quantity = scn.next();
//        boolean isvalid = new Validation().isValidprice_quantity(quantity);
//        while (!isvalid) {
//            System.out.println("Enter Item Quantity correct:");
//            this.quantity = scn.next();
//            isvalid = new Validation().isValidprice_quantity(quantity);
//        }
//
//    }
//
//    public void setTax() {
//        double value;
//        switch (type) {
//        case "Raw":
//            value = Double.parseDouble(price);
//            this.tax = new RawTax().tax(value);
//            break;
//        case "Manufactured":
//            value = Double.parseDouble(price);
//            this.tax = new ManufacturedTax().tax(value);
//            break;
//        case "Imported":
//            value = Double.parseDouble(price);
//            this.tax = new ImportedTax().tax(value);
//            break;
//
//        }
//    }
//
//    public Double getTax() {
//
//        return tax;
//    }
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Item getItem() {
        return new Item(name, type, price, quantity, tax);
    }

    public void display() {
        System.out.println("----------------------");
        System.out.println("Name ->" + name);
        System.out.println("Type ->" + type);
        System.out.println("Price ->" + price);
        System.out.println("Quantity ->" + quantity);
        System.out.println("------------------------");
    }
}
