package hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

    private String brand;
    @Id
    private int id;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
