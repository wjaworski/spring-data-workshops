package com.payu.workshops.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String street;

    @ManyToOne
    private City city;

    private String phone;

    @OneToMany(mappedBy = "customer")
    private Set<OrderDetails> orders;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer withName(String name) {
        this.name = name;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Customer withStreet(String street) {
        this.street = street;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Customer withCity(City city) {
        this.city = city;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Set<OrderDetails> getOrders() {
        return orders;
    }
}
