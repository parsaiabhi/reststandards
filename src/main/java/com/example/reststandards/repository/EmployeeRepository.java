package com.example.reststandards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reststandards.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
