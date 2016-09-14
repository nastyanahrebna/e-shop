package ua.lviv.shop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wild_bo on 17.07.16.
 */
@Entity
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Specifics specifics;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private List<Specifics> listSpecifics;

    public ProductType() {
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

    public List<Specifics> getListSpecifics() {
        return listSpecifics;
    }

    public void setListSpecifics(List<Specifics> listSpecifics) {
        this.listSpecifics = listSpecifics;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listSpecifics=" + listSpecifics +
                '}';
    }
}
