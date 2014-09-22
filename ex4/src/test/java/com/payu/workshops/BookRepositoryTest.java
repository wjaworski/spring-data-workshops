package com.payu.workshops;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.entities.Book;
import com.payu.workshops.entities.Employee;
import com.payu.workshops.repositories.BookRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class BookRepositoryTest extends AbstractJpaTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void shouldFindBooksByAuthor() {
        // when
        List<String> bookTitlesList = repository.giveMeAllBooksTitlesByAuthor("John Smith");

        // then
        assertThat(bookTitlesList, equalTo(Arrays.asList("Accounting 101", "Intermediate Accounting")));
    }

    @Test
    public void shouldFindBooksByAuthorWithPrizeLargerThan() {
        // when
        List<Book> booksList = repository.giveMeAllBooksByAuthorWithPrizeGraterThan("James White",
            BigDecimal.valueOf(100));

        // then
        assertThat(booksList.size(), equalTo(2));
        assertThat(booksList.get(0).getTitle(), equalTo("CPA Review"));
        assertThat(booksList.get(1).getTitle(), equalTo("Financial Accounting"));
    }

    @Test
    public void shouldReturnAvgPrize() {
        // when
        BigDecimal avgPrize = repository.giveMeAveragePrizeOfBooks();

        // then
        assertThat(avgPrize, closeTo(BigDecimal.valueOf(143.79), BigDecimal.valueOf(0.01)));
    }

    @Test
    public void shouldReturnSecondPageOfBooksByAuthor() {
        // when
        List<Book> booksList = repository.giveMeAllBooksByAuthorOrderedByPagesDesc("Mark Baker", new PageRequest(1, 2));

        // then
        assertThat(booksList.size(), equalTo(1));
        assertThat(booksList.get(0).getTitle(), equalTo("cost accounting"));
    }

    @Test
    public void shouldReturnEmployeeNamesWhoSoldBooksOfThisAuthor() {
        // when
        List<Employee> employeeList = repository.giveMeAllEmployeesWhoSoldBooksOfThisAuthor("Anna McQueen");

        // then
        assertThat(employeeList.size(), equalTo(2));
        assertThat(employeeList.get(0).getName(), equalTo("Jones Hoffer"));
        assertThat(employeeList.get(1).getName(), equalTo("Fred NcFaddeb"));
    }

    @Test
    public void shouldIncreaseBookPrize() {
        // when
        repository.increasePrizesByTenPercent(10506L);

        // then
        assertThat(repository.findOne(10506L).getPrize(), closeTo(BigDecimal.valueOf(135.30),
            BigDecimal.valueOf(0.01)));
    }
}
