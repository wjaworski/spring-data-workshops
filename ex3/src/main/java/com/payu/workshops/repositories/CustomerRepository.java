package com.payu.workshops.repositories;

import org.springframework.data.repository.CrudRepository;

import com.payu.workshops.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
