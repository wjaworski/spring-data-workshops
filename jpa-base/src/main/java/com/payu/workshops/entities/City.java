package com.payu.workshops.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    private Long zip;

    private String name;

    private String state;


    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    public City withZip(Long zip) {
        this.zip = zip;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City withName(String name) {
        this.name = name;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public City withState(String state) {
        this.state = state;
        return this;
    }
}
