package com.payu.workshops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payu.workshops.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {

}
