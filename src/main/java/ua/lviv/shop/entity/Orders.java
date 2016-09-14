package ua.lviv.shop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wild_bo on 25.07.16.
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int number;
    @Column
    private int price;
    @Temporal(TemporalType.DATE)
    @Column
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "id_order"), inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> productList;

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
