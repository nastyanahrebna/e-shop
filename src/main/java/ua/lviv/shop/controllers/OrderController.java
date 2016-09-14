package ua.lviv.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.lviv.shop.DTO.Cart;
import ua.lviv.shop.entity.Orders;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.User;
import ua.lviv.shop.services.OrdersService;
import ua.lviv.shop.services.ProductService;
import ua.lviv.shop.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wild_bo on 06.08.16.
 */

@Controller
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/cart/order/details", method = RequestMethod.GET)
    public String orderDetails(Model model, Principal principal){
        model.addAttribute("user", userService.findOneById(Integer.parseInt(principal.getName())));
        return "views-order-details";
    }

    @RequestMapping(value = "/cart/order/details", method = RequestMethod.POST)
    public String orderDetails(@RequestAttribute("user")User user){
        userService.edit(user);
        return "views-order-details";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String  cart(Model model){
        model.addAttribute("products", Cart.getInstance().getProductList());
        return "views-order-cart";
    }

    @RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
    public String  cart(@PathVariable String id){
        Cart.getInstance().getProductList().add(productService.findOneById(Integer.parseInt(id)));
        return "redirect:/";
    }

    @RequestMapping(value = "/cart/del/{id}")
        public String cartDel(@PathVariable("id") int id){

        Iterator<Product> iter = Cart.getInstance().getProductList().iterator();
        Product p;
        while(iter.hasNext()){
            p = iter.next();
            if(p.getId() == (id)){
                iter.remove();
            }
        }
            return "redirect:/cart";
        }


    @RequestMapping(value = "/cart/order", method = RequestMethod.POST)
    public String makeOrder(@RequestParam("id") int id, @RequestParam("number") int number, @RequestParam("price") int price, Principal principal){

        Orders orders = ordersService.add(number, ordersService.CostProduct(price, number), userService.findOneById(Integer.parseInt(principal.getName())));
        orders.setDate(new Date());

        List<Product> productList = new ArrayList<>();
        productList.add(productService.findOneById(id));

        orders.setProductList(productList);
        ordersService.add(orders);

        Iterator<Product> iter = Cart.getInstance().getProductList().iterator();
        Product p;
        while(iter.hasNext()){
            p = iter.next();
            if(p.getId() == (id)){
                iter.remove();
            }
        }
        return "redirect:/cart";
    }





}
