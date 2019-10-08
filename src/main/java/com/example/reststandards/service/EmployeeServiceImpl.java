package com.example.reststandards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reststandards.entity.Employee;
import com.example.reststandards.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abhishek
 *
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.reststandards.service.EmployeeService#getAllEmployees() will
	 * return all employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		log.debug("getting all employees");
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	
	
	

}
