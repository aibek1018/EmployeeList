package com.aayazbek.spring.mvc_hibernate.service.city;

import com.aayazbek.spring.mvc_hibernate.dao.country.CityDAO;
import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.CityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityDAO cityDAO;

    @Override
    @Transactional
    public List<City> getAllCities() {
        return cityDAO.getAllCities();
    }

    @Override
    @Transactional
    public void saveCity(City city) {
        cityDAO.saveCity(city);
    }

    @Override
    @Transactional
    public City getCity(int id) {
        return cityDAO.getCity(id);
    }

    @Override
    @Transactional
    public void deleteCity(int id) {
        cityDAO.deleteCity(id);
    }

    @Override
    @Transactional
    public List<CityDTO> findByCountry(int id) {
        return cityDAO.findByCountry(id);
    }
}
