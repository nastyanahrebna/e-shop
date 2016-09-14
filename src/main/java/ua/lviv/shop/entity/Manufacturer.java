package ua.lviv.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wild_bo on 17.07.16.
 */
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "manufacturer")
    private List<Product> productList;

    public Manufacturer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return name;
    }
}
