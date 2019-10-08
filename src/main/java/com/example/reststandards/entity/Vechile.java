package com.example.reststandards.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


/**
 * @author abhishek
 *
 */
@Entity
@Table(name = "vechile")
public class Vechile implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "carId")
	private Integer id;
	@NotEmpty(message = "please provide model")
	private String model;
	@NotEmpty(message = "please provide brand")
	private String brand;
	
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;


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


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Vechile [id=" + id + ", model=" + model + ", brand=" + brand + ", employee=" + employee + "]";
	}


	public Vechile(Integer id, String model, String brand, Employee employee) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.employee = employee;
	}


	public Vechile() {
		super();
	}

	
	
	

}
