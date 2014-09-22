package com.payu.workshops.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.payu.workshops.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByName(String name);

    List<Customer> findByStreetAndCityName(String street, String cityName);

    List<Customer> getByCityState(String cityState, Sort sort);

    List<Customer> findByCityStateOrderByNameAsc(String cityStat);

    List<Customer> findByPhoneLike(String phone);

    Integer countByCityZip(Long zip);
}
