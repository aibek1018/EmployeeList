package com.aayazbek.spring.mvc_hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee(int id, String name, String surname, String middleName, String phoneNumber, String email, Country country, City city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public Employee() {
    }

    public EmployeeDTO getDTO() {
        return new EmployeeDTO(
                this.id,
                this.name,
                this.surname,
                this.middleName,
                this.phoneNumber,
                this.email,
                this.country.getName(),
                this.city.getName()
        );
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "surname", length = 25)
    private String surname;

    @Column(name = "middle_name", length = 25)
    private String middleName;

    @Column(name = "phone_number", length = 25)
    private String phoneNumber;

    @Column(name = "email", length = 25)
    private String email;

    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city")
    private City city;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
