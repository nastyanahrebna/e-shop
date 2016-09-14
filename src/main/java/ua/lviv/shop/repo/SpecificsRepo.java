package ua.lviv.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.Specifics;

import java.util.List;

/**
 * Created by wild_bo on 20.08.16.
 */
public interface SpecificsRepo extends JpaRepository<Specifics, Integer> {

    @Query("SELECT s FROM Specifics s WHERE s.type.name LIKE :param")
    List<Specifics> findSpecificByType(@Param("param") String productType);
}
