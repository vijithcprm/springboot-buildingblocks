package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stacksimplify.restservices.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
