package com.aayazbek.spring.mvc_hibernate.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class Country {
    public Country(int id, String name, List<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
    private List<City> cities;

    public Country() {

    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
