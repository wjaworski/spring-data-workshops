package com.payu.workshops;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.documents.Book;
import com.payu.workshops.repositories.BookRepository;

import static com.mongodb.util.MyAsserts.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookRepositoryTest extends AbstractMongoTest {

    @Autowired
    BookRepository repository;

    @Test
    public void sanityTest() {
        assertTrue(true);
    }

    @Test
    public void shouldDeleteBook() {
        // when
        // TODO: uncomment
        // Book book = repository.findAll().iterator().next();

        // then
        // TODO: uncomment and make test working not changing this line
        // repository.delete(book.getId());
    }

    @Test
    public void shouldFindBooksByAuthorSortedByPrizeDesc() {
        // when
        List<Book> books = null; // TODO: get books written by "James White", sort by prize descending

        // then
        assertThat(books.size(), equalTo(3));
        assertThat(books.get(0).getTitle(), equalTo("CPA Review"));
        assertThat(books.get(1).getTitle(), equalTo("Financial Accounting"));
        assertThat(books.get(2).getTitle(), equalTo("Peachtree for Dummies"));
    }

    @Test
    public void shouldFindBookByAuthorAndTitle() {
        // when
        List<Book> books = null; // TODO: get books written by "James White" titled "Financial Accounting"

        // then
        assertThat(books.size(), equalTo(1));
        assertThat(books.get(0).getPrize(), closeTo(BigDecimal.valueOf(164.99), BigDecimal.valueOf(0.01)));
    }
}
