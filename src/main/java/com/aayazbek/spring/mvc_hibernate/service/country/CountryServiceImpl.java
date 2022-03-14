package com.aayazbek.spring.mvc_hibernate.service.country;

import com.aayazbek.spring.mvc_hibernate.dao.city.CountryDAO;
import com.aayazbek.spring.mvc_hibernate.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDAO countryDAO;

    @Override
    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getAllCountries();
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.saveCountry(country);
    }

    @Override
    @Transactional
    public Country getCountry(int id) {
        return countryDAO.getCountry(id);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        countryDAO.deleteCountry(id);
    }

    @Override
    @Transactional
    public List<Country> findByName(String name) {
        return countryDAO.findByName(name);
    }
}
