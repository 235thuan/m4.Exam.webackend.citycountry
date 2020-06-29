package service.Impl;

import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICountryRepository;
import service.ICountryService;

public class CountryServiceImpl implements ICountryService {
    @Autowired
    private ICountryRepository iCountryRepository;

    @Override
    public void save(Country country) {
    iCountryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
    iCountryRepository.delete(id);
    }

    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return iCountryRepository.findOne(id);
    }
}
