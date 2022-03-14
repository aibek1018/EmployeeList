package com.aayazbek.spring.mvc_hibernate.entity;

public class CityDTO {

    public int id;

    public String name;

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

    public CityDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
