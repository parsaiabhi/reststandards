package com.example.reststandards.service;

import java.util.List;

import com.example.reststandards.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
}
