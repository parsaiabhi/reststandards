package com.example.reststandards.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reststandards.dto.EmployeeRequestDto;
import com.example.reststandards.dto.EmployeeResponseDto;
import com.example.reststandards.entity.Employee;
import com.example.reststandards.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employees", produces = "application/json")
	private ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		log.debug("getting all employees{}", employeeList);
		List<EmployeeResponseDto> responseDto = employeeList.stream()
				.map(new Function<Employee, EmployeeResponseDto>() {

					@Override
					public EmployeeResponseDto apply(Employee emp) {
						return new EmployeeResponseDto(emp.getId(), emp.getName(), emp.getDesignation());
					}

				}).collect(Collectors.toList());

		return new ResponseEntity<List<EmployeeResponseDto>>(responseDto, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/employees/create" , produces = "application/json" , consumes = "application/json")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequestDto employeerequestDto){
		Employee emp = new Employee();
		emp.setName(employeerequestDto.getName());
		emp.setDesignation(employeerequestDto.getDesignation());
		Employee employeeCreated = employeeService.createEmployee(emp);
		return new ResponseEntity<Employee>(employeeCreated,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
}
