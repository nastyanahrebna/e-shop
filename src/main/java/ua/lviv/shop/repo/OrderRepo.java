package ua.lviv.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.shop.entity.Orders;

/**
 * Created by wild_bo on 08.08.16.
 */
public interface OrderRepo extends JpaRepository<Orders, Integer>{
}
