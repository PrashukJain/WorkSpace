package Details;

public class Item {

    private String name;
    private ItemType type;
    private String price;
    private String quantity;
    private Double tax;
    private Double finalPrice;

    /**
     * set the Name of item*
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the type of item *
     * 
     * @param type
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * set the price of item *
     * 
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * set the quantity of item*
     * 
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * set the tax of item
     * 
     * @param tax
     */
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * set the final price of item
     * 
     * @param tax
     */
    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * this method return name of item which is of String Datatype*
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * this method return type of item*
     * 
     * @return
     */
    public ItemType getType() {
        return type;
    }

    /**
     * this method return price of item which is of String Datatype*
     * 
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     * this method return quantity of item which is of String Datatype*
     * 
     * @return
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * this method return tax of item which is of Double Datatype*
     * 
     * @return
     */
    public Double getTax() {
        return tax;
    }

    /**
     * this method return final price of item which is of Double Datatype*
     * 
     * @return
     */
    public Double getFinalPrice() {
        return finalPrice;
    }

}
