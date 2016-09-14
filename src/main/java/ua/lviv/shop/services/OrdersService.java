package ua.lviv.shop.services;

import ua.lviv.shop.entity.Orders;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.User;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */
public interface OrdersService {
    Orders add(int number, int price, User user);
    void add(Orders orders);
    void edit(int id, int number, int price);
    void delete(int id);
    Orders findOneById(int id);
    List<Orders> findAll();
    int CostProduct(int price, int number);
}
