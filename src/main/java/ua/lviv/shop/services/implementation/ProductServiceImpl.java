package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.Promotion;
import ua.lviv.shop.repo.ManufacturerRepo;
import ua.lviv.shop.repo.ProductRepo;
import ua.lviv.shop.repo.SpecificsRepo;
import ua.lviv.shop.services.ProductService;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Autowired
    private SpecificsRepo specificsRepo;

    @Override
    public List<Product> searchProduct(String model) {
        return productRepo.searchProduct(model);
    }

    @Override
    public List<Product> findByProductType(String productType) {
        return productRepo.findByProductType(productType);
    }

    @Override
    public List<Product> findBySpecifics(String specific) {
        return productRepo.findBySpecifics(specific);
    }

    @Override
    public List<Product> findByPromotion(Promotion promotion) {
        return productRepo.findByPromotion(promotion);
    }


    public void add(String model, int number, int price, String characteristics, Promotion promotion, String code,
                    int id1, int id2) {
        Product product = new Product();
        product.setModel(model);
        product.setNumber(number);
        product.setPrice(price);
        product.setCharacteristics(characteristics);
        product.setPromotion(promotion);
        product.setCode(code);
        product.setManufacturer(manufacturerRepo.findOne(id1));
        product.setSpecifics(specificsRepo.findOne(id2));
        productRepo.save(product);
    }

    public Product addAndReturnProduct (String model, int number, int price, String characteristics, Promotion promotion, String code,
                    int id1, int id2) {
        Product product = new Product();
        product.setModel(model);
        product.setNumber(number);
        product.setPrice(price);
        product.setCharacteristics(characteristics);
        product.setPromotion(promotion);
        product.setCode(code);
        product.setManufacturer(manufacturerRepo.findOne(id1));
        product.setSpecifics(specificsRepo.findOne(id2));
        productRepo.save(product);

        return product;
    }

    public void add(Product product){
        productRepo.save(product);
    }

    public void edit(Product product){
        productRepo.save(product);
    }

    public void edit(int id, String model, int number, int price, String characteristics, Promotion promotion, String code) {
        Product product = productRepo.findOne(id);
        if(model != null){
            product.setModel(model);
        }
        if(number != 0){
            product.setNumber(number);
        }
        if(price != 0){
            product.setPrice(price);
        }
        if(characteristics != null){
            product.setCharacteristics(characteristics);
        }
        if(promotion != null){
            product.setPromotion(promotion);
        }
        if(code != null){
            product.setCode(code);
        }
        productRepo.save(product);
    }

    public void delete(int id) {
        Product product = productRepo.findOne(id);
        productRepo.delete(product);

    }

    public Product findOneById(int id) {
        return productRepo.findOne(id);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
