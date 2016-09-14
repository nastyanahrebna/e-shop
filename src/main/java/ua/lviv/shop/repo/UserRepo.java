package ua.lviv.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.lviv.shop.entity.User;

/**
 * Created by wild_bo on 08.08.16.
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email LIKE :param OR u.phone LIKE :param")
    User findUserByLogin(@Param("param")String login);

}
