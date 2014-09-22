package com.payu.workshops.repositories;

import org.springframework.data.repository.CrudRepository;

import com.payu.workshops.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
