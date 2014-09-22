package com.payu.workshops.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.payu.workshops.entities.Book;

public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void reverseWordsInBookTile(Long id) {
        Book book = em.find(Book.class, id);
        String[] titleParts = book.getTitle().split(" ");
        String reverseTitle = "";
        for (String titlePart : titleParts) {
            reverseTitle = titlePart + " " + reverseTitle;
        }
        book.setTitle(reverseTitle.trim());
    }
}
