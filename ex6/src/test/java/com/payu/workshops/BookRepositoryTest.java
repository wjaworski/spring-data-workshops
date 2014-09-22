package com.payu.workshops;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.documents.Book;
import com.payu.workshops.repositories.BookRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookRepositoryTest extends AbstractMongoTest {

    @Autowired
    BookRepository repository;

    @Test
    public void sanityTest() {
        assertTrue(true);
    }

    @Test
    public void shouldFindBooksByAuthorSortedByPrizeDesc() {
        // when
        List<Book> books = repository.findByAuthor("James White", new Sort(Sort.Direction.DESC, "prize"));

        // then
        assertThat(books.size(), equalTo(3));
        assertThat(books.get(0).getTitle(), equalTo("CPA Review"));
        assertThat(books.get(1).getTitle(), equalTo("Financial Accounting"));
        assertThat(books.get(2).getTitle(), equalTo("Peachtree for Dummies"));
    }

    @Test
    public void shouldFindBookByAuthorAndTitle() {
        // when
        List<Book> books = repository.giveMeBooksWithAuthorAndTitle("James White", "Financial Accounting");

        // then
        assertThat(books.size(), equalTo(1));
        assertThat(books.get(0).getPrize(), closeTo(BigDecimal.valueOf(164.99), BigDecimal.valueOf(0.01)));
    }
}
