package com.payu.workshops.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private City city;

    private String position;

    @OneToMany(mappedBy = "employee")
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

    public Employee withName(String name) {
        this.name = name;
        return this;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Employee withCity(City city) {
        this.city = city;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee withPosition(String position) {
        this.position = position;
        return this;
    }

    public Set<OrderDetails> getOrders() {
        return orders;
    }
}
