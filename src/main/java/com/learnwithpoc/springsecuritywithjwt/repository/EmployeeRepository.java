package com.learnwithpoc.springsecuritywithjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithpoc.springsecuritywithjwt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
