package com.payu.workshops.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.payu.workshops.entities.Book;
import com.payu.workshops.entities.Employee;

// TODO: annotate methods with proper JPA queries
public interface BookRepository extends JpaRepository<Book, Long> {

    List<String> giveMeAllBooksTitlesByAuthor(String author);

    List<Book> giveMeAllBooksByAuthorWithPrizeGraterThan(@Param("author") String author,
                                                         @Param("prize") BigDecimal prize);

    BigDecimal giveMeAveragePrizeOfBooks();

    List<Book> giveMeAllBooksByAuthorOrderedByPagesDesc(@Param("author") String author, Pageable pageable);

    List<Employee> giveMeAllEmployeesWhoSoldBooksOfThisAuthor(@Param("author") String author);

    void increasePrizesByTenPercent(@Param("id") Long id);
}
