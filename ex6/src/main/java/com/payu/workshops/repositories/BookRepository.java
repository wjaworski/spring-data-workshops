package com.payu.workshops.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.payu.workshops.documents.Book;

// TODO: PROPERLY extend interface for mongo repositories
public interface BookRepository extends MongoRepository<Book, Long> {

    List<Book> findByAuthor(String author, Sort sort);

    // TODO: annotate with proper MongoDB query
    //List<Book> giveMeBooksWithAuthorAndTitle(String author, String title);
}
