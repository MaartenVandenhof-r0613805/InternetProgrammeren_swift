package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Component {
    public String name;
    @Id
    @GeneratedValue
    private int id;

    public Component(String name) {
        this.name = name;
    }

    public Component() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    @ManyToOne(optional = false)
    private Product products;

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
