package ua.lviv.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.Promotion;
import ua.lviv.shop.entity.Specifics;
import ua.lviv.shop.services.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wild_bo on 28.07.16.
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SpecificsService specificsService;



    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productPage(@PathVariable String id, Model model){
        Product product = productService.findOneById(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "views-product-product";
    }

    @RequestMapping(value = "/product/{promotion}/page/{numberPage}", method = RequestMethod.GET)
    public String productPage(@PathVariable String promotion, @PathVariable int numberPage, Model model){

        List<Product> productList = productService.findByPromotion(Promotion.valueOf(promotion.toUpperCase()));
        int pages = sizePages(productList);

        productList = getProductList(productList, numberPage);

        model = pagination(numberPage, pages, model);
        model.addAttribute("products", productList);

        return "views-product-products";
    }

    @RequestMapping(value = "/catecorys/{catecory}/{numberPage}", method = RequestMethod.GET)
    public String catecory(@PathVariable String catecory, @PathVariable int numberPage, Model model) {

        List<Product> products = productService.findByProductType(catecory);
        List<Specifics> specificses = specificsService.findSpecificByType(catecory);

        int pages = sizePages(products);

        products = getProductList(products, numberPage);

        model = pagination(numberPage, pages, model);
        model.addAttribute("products", products);
        model.addAttribute("specifics", specificses);

        return "views-product-products";
    }

    @RequestMapping(value = "/catecory/{catecory}/{specifics}/{numberPage}", method = RequestMethod.GET)
    public String specifics(@PathVariable String catecory, @PathVariable String specifics, @PathVariable int numberPage, Model model) {

        List<Product> products = productService.findBySpecifics(specifics);
        List<Specifics> specificses = specificsService.findSpecificByType(catecory);

        int pages = sizePages(products);
        products = getProductList(products, numberPage);
        model = pagination(numberPage, pages, model);

        model.addAttribute("products", products);
        model.addAttribute("specifics", specificses);

        return "views-product-products";
    }


    private int sizePages(List<Product> productList){
        double sizeProducts = productList.size();
        int pages = (int)Math.ceil((sizeProducts / 8));
        return pages;
    }

    private List<Product> getProductList(List<Product> productList, int numberPage){

        List<Product> products = new ArrayList<>();

        int a = (numberPage - 1) * 8;
        int b = a + 7;

        if(b > productList.size() - 1){
            b = productList.size() - 1;
        }

        for(int i = a; i <= b; i++){
            products.add(productList.get(i));
        }

        return products;
    }


    private Model pagination(int numberPage, int pages, Model model){

        String link1 = (numberPage == 1) ? "" : "href=" + Integer.toString(numberPage - 1) + "";
        String link2 = (numberPage == pages) ? "" : "href=" + Integer.toString(numberPage +1) + "";

        model.addAttribute("link1", link1);
        model.addAttribute("link2", link2);
        model.addAttribute("pages", pages);

        return model;
    }

}
