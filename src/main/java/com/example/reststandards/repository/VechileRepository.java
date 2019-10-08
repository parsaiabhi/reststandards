package com.example.reststandards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reststandards.entity.Vechile;

public interface VechileRepository extends JpaRepository<Vechile,Integer>{
	
	List<Vechile> findVechileByEmployeeId(Integer empId);

}
