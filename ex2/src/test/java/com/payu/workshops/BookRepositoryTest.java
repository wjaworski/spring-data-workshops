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
        Iterable<Book> sortedBooksList = repository.findAll(new Sort(Sort.Direction.ASC, "prize"));

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
        Page<Book> secondPageBooksList = repository.findAll(new PageRequest(1, 3));

        // then
        Iterator<Book> iterator = secondPageBooksList.iterator();
        assertThat(iterator.next().getTitle(), equalTo("CPA Review"));
        assertThat(iterator.next().getTitle(), equalTo("Peachtree for Dummies"));
        assertThat(iterator.next().getTitle(), equalTo("Financial Accounting"));
    }

    @Test
    public void shouldThirdPageOfFourElementsPagesBeTheLastOne() {
        // when
        Page<Book> thirdPageBooksList = repository.findAll(new PageRequest(2, 4));
        int pageSize = thirdPageBooksList.getNumberOfElements();
        boolean isLast = thirdPageBooksList.isLast();
        boolean isFirst = thirdPageBooksList.isFirst();
        boolean hasNext = thirdPageBooksList.hasNext();
        boolean hasPrevious = thirdPageBooksList.hasPrevious();

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
        Page<Book> secondPageBooksList = repository.findAll(new PageRequest(0, 3, new Sort(new Sort.Order(
            Sort.Direction.ASC, "title").ignoreCase())));

        // then
        Iterator<Book> iterator = secondPageBooksList.iterator();
        assertThat(iterator.next().getTitle(), equalTo("Accounting 101"));
        assertThat(iterator.next().getTitle(), equalTo("cost accounting"));
        assertThat(iterator.next().getTitle(), equalTo("CPA Review"));
    }

}
