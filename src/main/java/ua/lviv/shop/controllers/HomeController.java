package ua.lviv.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.services.ProductService;

import java.util.List;

/**
 * Created by wild_bo on 19.07.16.
 */

@Controller
public class HomeController {

    String search;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String productsAll(){
        return "views-base-home";
    }

    @RequestMapping(value = "/search/result", method = RequestMethod.GET)
    public String search(Model model){

        List<Product> products = productService.searchProduct(this.search);
        model.addAttribute("products", products);

        return "views-base-search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("model") String model){

        this.search = model;

        return "redirect:/search/result";
    }

}

