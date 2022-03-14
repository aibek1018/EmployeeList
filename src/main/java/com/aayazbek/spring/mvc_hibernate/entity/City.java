package com.aayazbek.spring.mvc_hibernate.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public City(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CityDTO toDTO() {
        return new CityDTO(this.id, this.name);
    }

}
