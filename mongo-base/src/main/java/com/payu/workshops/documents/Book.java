package com.payu.workshops.documents;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private BigInteger id;

    private String title;

    private String author;

    private Long pages;

    private BigDecimal prize;

    public BigInteger getId() {
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

}
