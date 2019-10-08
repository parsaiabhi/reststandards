package com.example.reststandards.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VechileRequestDto {

	@NotEmpty(message = "{VechileRequestDto.empId.notEmpty}")
	@NotNull(message = "{VechileRequestDto.empId.notNull}")
	private Integer empId;
	private String model;
	private String brand;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "VechileRequestDto [empId=" + empId + ", model=" + model + ", brand=" + brand + "]";
	}

	public VechileRequestDto(Integer empId, String model, String brand) {
		super();
		this.empId = empId;
		this.model = model;
		this.brand = brand;
	}

	public VechileRequestDto() {
		super();
	}

}
