package com.aayazbek.spring.mvc_hibernate.service.country;

import com.aayazbek.spring.mvc_hibernate.entity.Country;

import java.util.List;

public interface CountryService {
    public List<Country> getAllCountries();

    public void saveCountry(Country country);

    public Country getCountry(int id);

    public void deleteCountry(int id);

    List<Country> findByName(String name);
}
