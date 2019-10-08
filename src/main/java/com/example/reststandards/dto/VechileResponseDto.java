package com.example.reststandards.dto;

public class VechileResponseDto {

	private Integer id;
	private String model;
	private String brand;

	public VechileResponseDto() {
		super();
	}

	public VechileResponseDto(Integer id, String model, String brand) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "VechileResponseDto [id=" + id + ", model=" + model + ", brand=" + brand + "]";
	}

}
