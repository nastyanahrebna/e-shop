package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.Manufacturer;
import ua.lviv.shop.repo.ManufacturerRepo;
import ua.lviv.shop.services.ManufacturerService;

import java.util.List;

/**
 * Created by wild_bo on 18.07.16.
 */

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    public void add(String name) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturerRepo.save(manufacturer);
    }

    public void edit(int id, String name) {
        Manufacturer manufacturer = manufacturerRepo.findOne(id);
        if(name != null){
            manufacturer.setName(name);
        }
        manufacturerRepo.save(manufacturer);
    }

    public void delete(int id) {
        Manufacturer manufacturer = manufacturerRepo.findOne(id);
        manufacturerRepo.delete(manufacturer);
    }

    public Manufacturer findOneById(int id) {
        return manufacturerRepo.findOne(id);
    }

    public List<Manufacturer> findAll() {
        return manufacturerRepo.findAll();
    }
}
