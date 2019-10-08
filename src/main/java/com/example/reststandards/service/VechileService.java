package com.example.reststandards.service;

import java.util.List;

import com.example.reststandards.entity.Vechile;
import com.example.reststandards.exception.VechileNotRegisteredException;

public interface VechileService {

	List<Vechile> getAllVechiles();
	
	Vechile registerVechile(Vechile vechile) throws VechileNotRegisteredException;
	
	List<Vechile> getVechileByEmpId(Integer empid);
}
