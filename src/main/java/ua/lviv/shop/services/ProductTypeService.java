package ua.lviv.shop.services;

import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.ProductType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */
public interface ProductTypeService {
    void  add(String name);
    void edit(int id, String name);
    void delete(int id);
    ProductType findOneById(int id);
    List<ProductType> findAll();
}
