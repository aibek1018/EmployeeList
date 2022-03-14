package com.aayazbek.spring.mvc_hibernate.dao.country;

import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.CityDTO;
import com.aayazbek.spring.mvc_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<City> getAllCities() {

        Session session = sessionFactory.getCurrentSession();
        List<City> allCities = session.createQuery("select c from City c", City.class).getResultList();

        return allCities;
    }

    @Override
    public void saveCity(City employee) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public City getCity(int id) {

        Session session = sessionFactory.getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public void deleteCity(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<City> query = session.createQuery("delete from City where id=:cityId");
        query.setParameter("cityId", id);
        query.executeUpdate();
    }

    @Override
    public List<CityDTO> findByCountry(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<City> cities = session
                .createQuery("select c from City c where c.country.id=:id", City.class)
                .setParameter("id", id)
                .getResultList();


        return cities.stream().map(City::toDTO).collect(Collectors.toList());
    }
}
