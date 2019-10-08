package com.example.reststandards.controller;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reststandards.dto.VechileRequestDto;
import com.example.reststandards.dto.VechileResponseDto;
import com.example.reststandards.entity.Vechile;
import com.example.reststandards.exception.VechileNotRegisteredException;
import com.example.reststandards.service.VechileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VechileController {

	@Autowired
	private VechileService vechileService;

	@GetMapping(value = "/vechiles", produces = "application/json")
	public ResponseEntity<List<VechileResponseDto>> getAllvechiles() {
		List<Vechile> vechileList = vechileService.getAllVechiles();
		log.debug("getting vechileList{}", vechileList);
		List<VechileResponseDto> vechileResponseDto = vechileList.stream()
				.map(new Function<Vechile, VechileResponseDto>() {

					@Override
					public VechileResponseDto apply(Vechile vechile) {
						return new VechileResponseDto(vechile.getId(), vechile.getBrand(), vechile.getModel());
					}

				}).collect(Collectors.toList());

         /*the below commented statement is same as above diff. is above one  is with function and below one is using lambda*/
		
/*		List<VechileResponseDto> vechileRes = vechileList.stream()
				.map(v -> new VechileResponseDto(v.getId(), v.getBrand(), v.getModel())).collect(Collectors.toList());*/

		return new ResponseEntity<List<VechileResponseDto>>(vechileResponseDto, HttpStatus.OK);
	}

	@PostMapping(value = "vechiles/create")
	public ResponseEntity<VechileResponseDto> cerateVechile(@Valid @RequestBody VechileRequestDto vechileRequestDto) {
		Vechile vechile = new Vechile();
		vechile.setId(vechileRequestDto.getEmpId());
		vechile.setBrand(vechileRequestDto.getBrand());
		vechile.setModel(vechileRequestDto.getModel());
		VechileResponseDto vechileResponseDto = new VechileResponseDto();
		Vechile returnedVechile = null;
		try {
			returnedVechile = vechileService.registerVechile(vechile);
			vechileResponseDto.setBrand(returnedVechile.getBrand());
			vechileResponseDto.setModel(returnedVechile.getModel());
			vechileResponseDto.setId(returnedVechile.getId());
		} catch (VechileNotRegisteredException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<VechileResponseDto>(vechileResponseDto, HttpStatus.OK);
	}

	@GetMapping(value = "vechiles/{empid}/employees")
	public ResponseEntity<List<Vechile>> getVechilesByEmpId(@PathVariable("empid") @Positive(message = "id should be positive")  Integer empid) {
		return new ResponseEntity<List<Vechile>>(vechileService.getVechileByEmpId(empid), HttpStatus.OK);
	}

}
