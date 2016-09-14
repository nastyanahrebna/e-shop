package ua.lviv.shop.entity;

import javax.persistence.*;

/**
 * Created by wild_bo on 07.08.16.
 */

@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Product product;

    public ProductImage() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
