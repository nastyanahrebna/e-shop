package ua.lviv.shop.services;

import ua.lviv.shop.entity.User;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */
public interface UserService {
    void  add(String firsName, String lastName, String password, String email, String phone, String address);
    void add(User user);
    void edit(int id, String firsName, String lastName, String password, String email, String phone, String address);
    void edit(User user);
    void delete(int id);
    User findOneById(int id);
    List<User> findAll();
    void sendEmail(int id, String email, String userName, String password, String registrationVar);

}
