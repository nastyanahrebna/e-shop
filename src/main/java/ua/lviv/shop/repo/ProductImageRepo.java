package ua.lviv.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.ProductImage;

import java.util.ArrayList;

/**
 * Created by wild_bo on 08.08.16.
 */
public interface ProductImageRepo extends JpaRepository<ProductImage, Integer> {

    @Query("SELECT id FROM ProductImage p WHERE p.product.id = :param")
    ArrayList<Integer> productId(@Param("param") int productId);

}
