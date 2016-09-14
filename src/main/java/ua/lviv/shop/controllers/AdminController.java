package ua.lviv.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.ProductImage;
import ua.lviv.shop.entity.Promotion;
import ua.lviv.shop.services.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wild_bo on 28.07.16.
 */

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private SpecificsService specificsService;


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String manufacturerAll(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("specifics", specificsService.findAll());
        model.addAttribute("promotion", Promotion.values());
        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addProduct( @RequestParam("model") String model, @RequestParam("number") int number,
                              @RequestParam("price") int price, @RequestParam("characteristics") String characteristics,
                              @RequestParam("promotion") Promotion promotion, @RequestParam("code") String code,
                              @RequestParam("manufacturer")Integer id1, @RequestParam("specifics") Integer id2,
                              @RequestParam("img") MultipartFile[] images){

        Product product = productService.addAndReturnProduct(model, number, price, characteristics, promotion, code, id1, id2);
        List<ProductImage> productImageList = new ArrayList<>();

        for (MultipartFile image : images) {

            ProductImage productImage = new ProductImage();
            productImage.setName(image.getOriginalFilename());

            productImage.setProduct(product);
            productImageList.add(productImage);

            productImageService.saveAndFlash(productImage);

            File file = new File("/home/wild_bo/Development/Workspaces/IdeaDefault/shop/src/main/webapp/resources/images/"+product.getId()+"/"+image.getOriginalFilename());
            file.mkdirs();
            try {
                image.transferTo(file);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        product.setProductImages(productImageList);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/productEdit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, Model model){
        model.addAttribute("product", productService.findOneById(Integer.parseInt(id)));
        model.addAttribute("promotion", Promotion.values());
        model.addAttribute("manufacturer", manufacturerService.findAll());
        model.addAttribute("productType", productTypeService.findAll());
        return "views-product-productEdit";
    }

    @RequestMapping(value ="/productEdit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id, @RequestParam("model") String model, @RequestParam("number") int number,
                       @RequestParam("price") int price, @RequestParam("characteristics") String characteristics,
                       @RequestParam("promotion") Promotion promotion, @RequestParam("code") String code){
        System.out.println(id);
        productService.edit(id, model, number, price, characteristics, promotion, code);
        return "redirect:/product/" + id;
    }

}