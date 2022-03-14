package com.aayazbek.spring.mvc_hibernate.dao.country;

import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.CityDTO;
import com.aayazbek.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface CityDAO {

    public List<City> getAllCities();

    public void saveCity(City city);

    public City getCity(int id);

    public void deleteCity(int id);

    public List<CityDTO> findByCountry(int id);
}
