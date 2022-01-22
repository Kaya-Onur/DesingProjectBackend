package com.example.designProjectPets.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designProjectPets.business.abstracts.DistrictService;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.District;

@RestController
@RequestMapping("/api/1.0/admin/districts")
public class DistrictController {
	
	private DistrictService districtService;

	@Autowired
	public DistrictController(DistrictService districtService) {
		super();
		this.districtService = districtService;
	}
	
	@PostMapping("/add")
	public Result districtAdd(@Valid @RequestBody District district) {
		return this.districtService.districtAdd(district);
		
	}
	@GetMapping("/getAll")
	public Result districtGetAll() {
		return this.districtService.districtGetAll();
	}
	
	@DeleteMapping("/delete")
	public Result districtDelete(int districtId) {
		return this.districtService.districtDelete(districtId);
	}

	@PutMapping("/update")
	public Result districtUpdate(@Valid @RequestBody District district) {
		return this.districtService.districtUpdate(district);
	}

}