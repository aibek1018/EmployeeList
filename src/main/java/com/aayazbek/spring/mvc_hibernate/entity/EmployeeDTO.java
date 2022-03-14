package com.aayazbek.spring.mvc_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EmployeeDTO {

    public EmployeeDTO(int id, String name, String surname, String middleName, String phoneNumber, String email, String country, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public int id;

    public String name;

    public String surname;

    public String middleName;

    public String phoneNumber;

    public String email;

    public String country;

    public String city;
}
