package com.payu.workshops;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.entities.Book;
import com.payu.workshops.repositories.BookRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookRepositoryTest extends AbstractJpaTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void shouldFindBooksSortedByPrizeAsc() {
        // when
        Iterable<Book> sortedBooksList = null; // TODO: find all books sorted by prize ascending

        // then
        Iterator<Book> iterator = sortedBooksList.iterator();
        assertThat(iterator.next().getTitle(), equalTo("Peachtree for Dummies"));
        assertThat(iterator.next().getTitle(), equalTo("Management 101"));
        assertThat(iterator.next().getTitle(), equalTo("XBRL in Nutshell"));
        assertThat(iterator.next().getTitle(), equalTo("Managerial Accounting"));
    }

    @Test
    public void shouldFindBooksSecondPageOfThreeElementsPages() {
        // when
        Page<Book> secondPageBooksList = null; // TODO: find all books with paging of 3 elements, get the second page

        // then
        Iterator<Book> iterator = secondPageBooksList.iterator();
        assertThat(iterator.next().getTitle(), equalTo("CPA Review"));
        assertThat(iterator.next().getTitle(), equalTo("Peachtree for Dummies"));
        assertThat(iterator.next().getTitle(), equalTo("Financial Accounting"));
    }

    @Test
    public void shouldThirdPageOfFourElementsPagesBeTheLastOne() {
        // when
        Page<Book> thirdPageBooksList = null; // // TODO: find all books with paging of 4 elements, get the third page
        int pageSize = thirdPageBooksList.getNumberOfElements();
        boolean isLast = false; // TODO: check if current page is last
        boolean isFirst = false; // TODO: check if current page is first
        boolean hasNext = false; // TODO: check if current page has next
        boolean hasPrevious = false; // TODO: check if current page has previous

        // then
        assertThat(pageSize, equalTo(2));
        assertThat(isLast, equalTo(true));
        assertThat(isFirst, equalTo(false));
        assertThat(hasNext, equalTo(false));
        assertThat(hasPrevious, equalTo(true));
    }

    @Test
    public void shouldFindBooksFirstPageOfThreeElementsPagesSortedByTitleIgnoreCaseAsc() {
        // when
        // TODO: find all books sorted by title ascending (not case sensitive) paged by 3 elements, get the first page
        Page<Book> secondPageBooksList = null;

        // then
        Iterator<Book> iterator = secondPageBooksList.iterator();
        assertThat(iterator.next().getTitle(), equalTo("Accounting 101"));
        assertThat(iterator.next().getTitle(), equalTo("cost accounting"));
        assertThat(iterator.next().getTitle(), equalTo("CPA Review"));
    }

}
