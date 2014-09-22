package com.payu.workshops.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payu.workshops.entities.Book;
import com.payu.workshops.entities.Employee;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b.title from Book b where b.author = ?1")
    List<String> giveMeAllBooksTitlesByAuthor(String author);

    @Query("from Book b where b.author = :author and prize > :prize")
    List<Book> giveMeAllBooksByAuthorWithPrizeGraterThan(@Param("author") String author,
                                                         @Param("prize") BigDecimal prize);

    @Query("select avg(b.prize) from Book b")
    BigDecimal giveMeAveragePrizeOfBooks();

    @Query("from Book b where b.author = :author order by pages desc")
    List<Book> giveMeAllBooksByAuthorOrderedByPagesDesc(@Param("author") String author, Pageable pageable);

    @Query("select o.employee from Book b join b.orders o where b.author = :author")
    List<Employee> giveMeAllEmployeesWhoSoldBooksOfThisAuthor(@Param("author") String author);

    @Modifying
    @Query("update Book b set b.prize = b.prize * 1.1 where b.id = :id")
    void increasePrizesByTenPercent(@Param("id") Long id);
}
