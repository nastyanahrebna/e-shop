package ua.lviv.shop.services;

import org.springframework.web.multipart.MultipartFile;
import ua.lviv.shop.entity.ProductImage;

import java.util.ArrayList;

/**
 * Created by wild_bo on 07.08.16.
 */

public interface ProductImageService {

//    void saveFile(MultipartFile file, String id);

    void deleteImgs(int id);

    void saveAndFlash(ProductImage productImage);

    ArrayList<Integer> productId(int id);

}
