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

import com.example.designProjectPets.business.abstracts.AdvertService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Advert;
import com.example.designProjectPets.entities.dtos.AdvertWithAddressDto;



@RestController
@RequestMapping("/api/1.0/all/adverts")
public class AdvertController {
	
	private AdvertService advertService;

	@Autowired
	public AdvertController(AdvertService advertService) {
		super();
		this.advertService = advertService;
	}

	@PostMapping("/add")
	public Result advertAdd(@Valid @RequestBody AdvertWithAddressDto advertWithAddressDto) {
		return this.advertService.advertWithAddressDto(advertWithAddressDto);

	}

	@GetMapping("/getAll")
	public Result advertGetAll() {
		return this.advertService.advertGetAll();
	}

	@DeleteMapping("/delete")
	public Result advertDelete(int advertId) {
		return this.advertService.advertDelete(advertId);
	}

	@PutMapping("/update")
	public Result advertUpdate(@Valid @RequestBody AdvertWithAddressDto advertWithAddressDto) {
		return this.advertService.advertUpdate(advertWithAddressDto);
	}
	
	@GetMapping("/advertId")			
	public DataResult<Advert> getByadvertId(int advertId){
		return this.advertService.getByadvertId(advertId);
	}

}
