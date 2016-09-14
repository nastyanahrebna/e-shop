package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.shop.entity.ProductImage;
import ua.lviv.shop.repo.ProductImageRepo;
import ua.lviv.shop.services.ProductImageService;

import java.util.ArrayList;

/**
 * Created by wild_bo on 07.08.16.
 */

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepo productImageRepo;

    @Transactional
    @Override
    public void deleteImgs(int productId) {

        ArrayList<Integer> productImages = productImageRepo.productId(productId);

        System.out.println(productId);

        for (int n :productImages) {
            productImageRepo.delete(n);
            System.out.println(n);
        }

    }

    public void saveAndFlash(ProductImage productImage){
        productImageRepo.saveAndFlush(productImage);
    }

    @Override
    public ArrayList<Integer> productId(int id) {
        return productImageRepo.productId(id);
    }
}
