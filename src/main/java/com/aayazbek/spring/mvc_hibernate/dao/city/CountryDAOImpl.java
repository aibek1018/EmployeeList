package com.aayazbek.spring.mvc_hibernate.dao.city;

import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getAllCountries() {

        Session session = sessionFactory.getCurrentSession();
        List<Country> allCountries = session.createQuery("select c from Country c", Country.class).getResultList();

        return allCountries;
    }

    @Override
    public void saveCountry(Country country) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(country);
    }

    @Override
    public Country getCountry(int id) {

        Session session = sessionFactory.getCurrentSession();
        Country country = session.get(Country.class, id);
        return country;
    }

    @Override
    public void deleteCountry(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Country> query = session.createQuery("delete from Country where id=:countryId");
        query.setParameter("countryId", id);
        query.executeUpdate();
    }

    @Override
    public List<Country> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        List<Country> allEmployees = session
                .createQuery("select c from Country c where c.name = :name ", Country.class)
                .setParameter("name", name)
                .getResultList();
        return allEmployees;
    }
}
