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

import com.example.designProjectPets.business.abstracts.CityService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.City;

@RestController
@RequestMapping("/api/1.0/admin/cities")
public class CityController {
	
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result cityAdd(@Valid @RequestBody City city) {
		return this.cityService.cityAdd(city);
		
	}
	@GetMapping("/getAll")
	public Result cityGetAll() {
		return this.cityService.cityGetAll();
	}
	
	@DeleteMapping("/delete")
	public Result cityDelete(int cityId) {
		return this.cityService.cityDelete(cityId);
	}

	@PutMapping("/update")
	public Result cityUpdate(@Valid @RequestBody City city) {
		return this.cityService.cityUpdate(city);
	}
	
	@GetMapping("/cityId")			
	public DataResult<City> getBycityId(int cityId){
		return this.cityService.getBycityId(cityId);
	}
	
	

}
