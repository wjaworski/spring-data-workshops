package com.payu.workshops.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.payu.workshops.entities.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
