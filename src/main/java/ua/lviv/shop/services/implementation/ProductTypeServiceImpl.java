package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.ProductType;
import ua.lviv.shop.repo.ProductTypeRepo;
import ua.lviv.shop.services.ProductTypeService;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepo productTypeRepo;

    public void add(String name) {
        ProductType productType = new ProductType();
        productType.setName(name);
        productTypeRepo.save(productType);
    }

    public void edit(int id, String name) {
        ProductType productType = productTypeRepo.findOne(id);
        if(name != null){
            productType.setName(name);
        }
        productTypeRepo.save(productType);
    }

    public void delete(int id) {
        ProductType productType = productTypeRepo.findOne(id);
        productTypeRepo.delete(productType);
    }

    public ProductType findOneById(int id) {
        return productTypeRepo.findOne(id);
    }

    public List<ProductType> findAll() {
        return productTypeRepo.findAll();
    }

}
