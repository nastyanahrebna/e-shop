package ua.lviv.shop.services;

import ua.lviv.shop.entity.Manufacturer;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */
public interface ManufacturerService {
    public void  add(String name);
    public void edit(int id, String name);
    public void delete(int id);
    public Manufacturer findOneById(int id);
    public List<Manufacturer> findAll();
}
