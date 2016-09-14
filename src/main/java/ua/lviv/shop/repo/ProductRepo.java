package ua.lviv.shop.repo;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.Promotion;

import java.util.List;

/**
 * Created by wild_bo on 08.08.16.
 */
public interface ProductRepo extends JpaRepository<Product, Integer>{

    @Query("SELECT p FROM Product p WHERE p.model LIKE %:param%")
    List<Product> searchProduct(@Param("param") String model);

    @Query("SELECT p FROM Product p JOIN p.specifics s JOIN s.type pt WHERE pt.name LIKE :param")
    List<Product> findByProductType(@Param("param") String productType);

    @Query("SELECT p FROM Product p JOIN p.specifics s WHERE s.name LIKE :param")
    List<Product> findBySpecifics(@Param("param") String specific);

    @Query("SELECT p FROM Product p WHERE p.promotion = :promotion")
    List<Product> findByPromotion(@Param("promotion") Promotion promotion);
}
