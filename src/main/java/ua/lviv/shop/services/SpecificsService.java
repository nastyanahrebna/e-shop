package ua.lviv.shop.services;

import ua.lviv.shop.entity.Manufacturer;
import ua.lviv.shop.entity.Specifics;

import java.util.List;

/**
 * Created by wild_bo on 20.08.16.
 */
public interface SpecificsService {

    void add(String name);
    void edit(int id, String name);
    void delete(int id);
    Specifics findOneById(int id);
    List<Specifics> findAll();
    List<Specifics> findSpecificByType(String productType);

}
