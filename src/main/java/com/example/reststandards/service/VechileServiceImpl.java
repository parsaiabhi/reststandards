package com.example.reststandards.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reststandards.entity.Employee;
import com.example.reststandards.entity.Vechile;
import com.example.reststandards.exception.VechileNotRegisteredException;
import com.example.reststandards.repository.EmployeeRepository;
import com.example.reststandards.repository.VechileRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * @author abhishek
 *
 */
@Service
@Slf4j
public class VechileServiceImpl implements VechileService {

	@Autowired
	private VechileRepository vechileRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	/* (non-Javadoc)
	 * @see com.example.reststandards.service.VechileService#getAllVechiles()
	 * will return all vechiles
	 */
	@Override
	public List<Vechile> getAllVechiles() {
		log.debug("getting all vechiles");
		return vechileRepository.findAll();
	}


	@Override
	public Vechile registerVechile(Vechile vechile) throws VechileNotRegisteredException{
		Optional<Employee> emp = employeeRepository.findById(vechile.getId());
		
		Vechile returnedVechile = null;
		if(emp.isPresent()) {
			Employee e = emp.get();
			log.debug("emp is{}", e);
			if(e.getId() == vechile.getId()) {
				vechile.setEmployee(e);
				returnedVechile =  vechileRepository.save(vechile);
			}
		}else {
			throw new VechileNotRegisteredException("vechile can not registerd");
		}
		return returnedVechile;
		
	}


	@Override
	public List<Vechile> getVechileByEmpId(Integer empid) {
		return vechileRepository.findVechileByEmployeeId(empid);
	}
	
	
	

}
