package com.aayazbek.spring.mvc_hibernate.service.city;


import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.CityDTO;

import java.util.List;

public interface CityService {
    public List<City> getAllCities();

    public void saveCity(City country);

    public City getCity(int id);

    public void deleteCity(int id);

    public List<CityDTO> findByCountry(int id);
}
