package ua.lviv.shop.DTO;

import ua.lviv.shop.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wild_bo on 27.08.16.
 */
public class Cart {

    private static Cart instance;
    private List<Product> productList;

    private Cart() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productList=" + productList +
                '}';
    }

    public static Cart getInstance(){
       if(instance == null){
           return instance = new Cart();
       }else{
           return instance;
       }
    }
}
