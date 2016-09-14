package ua.lviv.shop.services;

import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.Promotion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */
public interface ProductService {

    List<Product> searchProduct(String model);
    List<Product> findByProductType(String productType);
    List<Product> findBySpecifics(String specific);
    List<Product> findByPromotion(Promotion promotion);
    void add(String model, int number, int price, String characteristics, Promotion promotion, String code, int id1, int id2);
    Product addAndReturnProduct(String model, int number, int price, String characteristics, Promotion promotion, String code, int id1, int id2);
    void add(Product product);
    void edit(int id, String model, int number, int price, String characteristics, Promotion promotion, String code);
    void edit(Product product);
    void delete(int id);
    Product findOneById(int id);
    List<Product> findAll();
}
