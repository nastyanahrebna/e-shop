package ua.lviv.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.Product;
import ua.lviv.shop.entity.ProductType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wild_bo on 08.08.16.
 */
public interface ProductTypeRepo extends JpaRepository<ProductType, Integer> {



}
