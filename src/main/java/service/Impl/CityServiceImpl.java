package service.Impl;

import model.City;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICityRepository;
import service.ICityService;

public class CityServiceImpl implements ICityService {
    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return iCityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        iCityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.delete(id);
    }
}
