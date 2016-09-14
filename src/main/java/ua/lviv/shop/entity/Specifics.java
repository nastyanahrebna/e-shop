package ua.lviv.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wild_bo on 20.08.16.
 */

@Entity
public class Specifics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "specifics", fetch = FetchType.EAGER)
    private List<Product> productList;

//    @OneToMany(mappedBy = "specifics")
//    private List<ProductType> productTypes;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductType type;

    public Specifics() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Specifics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                ", type=" + type +
                '}';
    }
}
