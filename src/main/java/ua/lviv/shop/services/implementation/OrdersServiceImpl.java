package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.Orders;
import ua.lviv.shop.entity.User;
import ua.lviv.shop.repo.OrderRepo;
import ua.lviv.shop.services.OrdersService;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private  OrderRepo orderRepo;

    public Orders add(int number, int price, User user) {
        Orders orders = new Orders();
        orders.setNumber(number);
        orders.setPrice(price);
        orders.setUser(user);
        return orderRepo.save(orders);
    }

    public void add(Orders orders) {
        orderRepo.save(orders);
    }

    public void edit(int id, int number, int price) {
        Orders orders = orderRepo.findOne(id);
        if(number != 0){
            orders.setNumber(number);
        }
        if(price != 0){
            orders.setPrice(price);
        }
        orderRepo.save(orders);
    }

    public void delete(int id) {
        Orders orders = orderRepo.findOne(id);
        orderRepo.delete(orders);
    }

    public Orders findOneById(int id) {
        return orderRepo.findOne(id);
    }

    public List<Orders> findAll() {
        return orderRepo.findAll();
    }

    public int CostProduct(int price, int number){
        return price * number;
    }


}
