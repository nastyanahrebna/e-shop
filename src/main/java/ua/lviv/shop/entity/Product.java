package ua.lviv.shop.entity;


import javax.persistence.*;
import java.util.List;


/**
 * Created by wild_bo on 17.07.16.
 */@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String model;
    @Column
    private int number;
    @Column
    private int price;
    @Column(columnDefinition="TEXT")
    private String characteristics;
    @Enumerated(EnumType.STRING)
    private Promotion promotion;
    @Column
    private String code;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<ProductImage> productImages;
    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer manufacturer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Specifics specifics;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_order"))
    private List<Orders> orderList;

    public Product() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Specifics getSpecifics() {
        return specifics;
    }

    public void setSpecifics(Specifics specifics) {
        this.specifics = specifics;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", characteristics='" + characteristics + '\'' +
                ", promotion=" + promotion +
                ", code='" + code + '\'' +
                ", productImages=" + productImages +
                ", manufacturer=" + manufacturer +
                ", specifics=" + specifics +
                ", orderList=" + orderList +
                '}';
    }
}
