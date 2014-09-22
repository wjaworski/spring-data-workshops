package com.payu.workshops.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.payu.workshops.documents.Book;

public interface BookRepository extends CrudRepository<Book, BigInteger> {

    List<Book> findByAuthor(String author, Sort sort);

    @Query("{ author : ?0, title : ?1 }")
    List<Book> giveMeBooksWithAuthorAndTitle(String author, String title);
}
