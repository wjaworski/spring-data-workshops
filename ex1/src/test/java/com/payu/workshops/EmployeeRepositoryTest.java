package com.payu.workshops;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.payu.workshops.entities.Employee;
import com.payu.workshops.repositories.EmployeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

@ContextConfiguration(classes = {ApplicationConfig.class})
public class EmployeeRepositoryTest extends AbstractJpaTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    public void shouldFindEmployeeById() {
        // when
        Employee employee = repository.findOne(1201L);

        //then
        assertThat(employee.getName(), equalTo("Jones Hoffer"));
    }

    @Test
    public void shouldFindGivenEmployees() {
        // when
        Iterable<Employee> employees = repository.findAll(Arrays.asList(1202L, 1203L));

        //then
        assertThat(employees, is(Matchers.<Employee>iterableWithSize(2)));
        assertThat(employees, containsInAnyOrder(
            hasProperty("id", equalTo(1202L)),
            hasProperty("id", equalTo(1203L))));
    }

    @Test
    public void shouldDeleteEmployeeById() {
        // when
        repository.delete(1202L);

        // then
        long count = repository.count();
        assertThat(count, equalTo(2L));
    }

    @Test
    public void shouldSaveSingleEmployee() {
        // given
        Employee newEmployee = new Employee()
            .withName("Adam Smith")
            .withPosition("HR manager");

        // when
        repository.save(newEmployee);

        // then
        long count = repository.count();
        assertThat(count, equalTo(4L));
    }

    @Test
    public void shouldSaveCollectionOfEmployees() {
        // given
        List<Employee> listOfEmployees = Arrays.asList(
            new Employee()
                .withName("James Brown"),
            new Employee()
                .withName("Fred Gray"));

        // when
        repository.save(listOfEmployees);

        // then
        long count = repository.count();
        assertThat(count, equalTo(5L));
    }
}
