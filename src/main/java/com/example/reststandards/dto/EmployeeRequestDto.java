package com.example.reststandards.dto;

public class EmployeeRequestDto {

	private String name;
	private String designation;

	public EmployeeRequestDto() {
		super();
	}

	public EmployeeRequestDto(String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeRequestDto [name=" + name + ", designation=" + designation + "]";
	}

}
