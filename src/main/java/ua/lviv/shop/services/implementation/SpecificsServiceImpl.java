package ua.lviv.shop.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.shop.entity.Specifics;
import ua.lviv.shop.repo.SpecificsRepo;
import ua.lviv.shop.services.SpecificsService;

import java.util.List;

/**
 * Created by wild_bo on 20.08.16.
 */

@Service
public class SpecificsServiceImpl implements SpecificsService {

    @Autowired
    private SpecificsRepo specificsRepo;

    @Override
    public void add(String name) {
        Specifics specifics = new Specifics();
        specifics.setName(name);
        specificsRepo.save(specifics);
    }

    @Override
    public void edit(int id, String name) {
        Specifics specifics = findOneById(id);
        if(name != null){
            specifics.setName(name);
        }
        specificsRepo.save(specifics);
    }

    @Override
    public void delete(int id) {
        specificsRepo.delete(id);
    }

    @Override
    public Specifics findOneById(int id) {
        return specificsRepo.findOne(id);
    }

    @Override
    public List<Specifics> findAll() {
        return specificsRepo.findAll();
    }

    @Override
    public List<Specifics> findSpecificByType(String productType) {
        return specificsRepo.findSpecificByType(productType);
    }
}
