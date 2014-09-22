package com.payu.workshops;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.entities.Customer;
import com.payu.workshops.repositories.CustomerRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class CustomerRepositoryTest extends AbstractJpaTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void shouldFindByCustomerName() {
        // when
        Customer robertSmithCustomer = null; // TODO: get customer with name "Robert Smith"

        // then
        assertThat(robertSmithCustomer.getId(), equalTo(23514L));

    }

    @Test
     public void shouldFindByStreetAndTheNameOfTheCityName() {
        // when
        List<Customer> customers = null; // TODO: get customers living on street "123 Main St." in the city "Bellingham"

        // then
        assertThat(customers.size(), equalTo(2));
    }

    @Test
    public void shouldFindCustomersByStateSortedByNameAsc() {
        // when
        List<Customer> customers = null; // TODO: get customers living in state "CA",
        // sorted by name ascending (use Sort parameter)

        // then
        assertThat(customers.size(), equalTo(3));
        assertThat(customers, contains(
            hasProperty("name", equalTo("Adam Beethoven")),
            hasProperty("name", equalTo("George Myer")),
            hasProperty("name", equalTo("Robert Smith"))
        ));
    }

    @Test
    public void shouldFindCustomersByStateSortedByNameAscending2() {
        // when
        List<Customer> customers = null; // TODO: get customers living in state "CA",
        // sorted by name ascending (DO NOT use Sort parameter)

        // then
        assertThat(customers.size(), equalTo(3));
        assertThat(customers, contains(
            hasProperty("name", equalTo("Adam Beethoven")),
            hasProperty("name", equalTo("George Myer")),
            hasProperty("name", equalTo("Robert Smith"))
        ));
    }

    @Test
    public void shouldFindByPhonePrefix() {
        // when
        List<Customer> customers = null; // TODO: get customers with phone numbers starting "209-"

        // then
        assertThat(customers.size(), equalTo(2));
    }

    @Test
    public void shouldCountByZip() {
        // when
        Integer count = null; // TODO: count customers living in the city with zip code 98225

        // then
        assertThat(count, equalTo(3));
    }
}