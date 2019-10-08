package com.example.reststandards.dto;

public class EmployeeResponseDto {

	private Integer id;
	private String name;
	private String designation;

	public EmployeeResponseDto() {
		super();
	}

	public EmployeeResponseDto(Integer id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "EmployeeResponseDto [id=" + id + ", name=" + name + ", designation=" + designation + "]";
	}

}
