package com.payu.workshops.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private Long pages;

    private BigDecimal prize;

    @OneToMany(mappedBy = "book")
    private Set<OrderDetails> orders;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book withAuthor(String author) {
        this.author = author;
        return this;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Book withPages(Long pages) {
        this.pages = pages;
        return this;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public Book withPrize(BigDecimal prize) {
        this.prize = prize;
        return this;
    }

    public Set<OrderDetails> getOrders() {
        return orders;
    }

}
