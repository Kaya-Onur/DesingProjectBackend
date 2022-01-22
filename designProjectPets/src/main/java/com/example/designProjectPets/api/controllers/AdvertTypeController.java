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
import com.example.designProjectPets.business.abstracts.AdvertTypeService;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Advert;
import com.example.designProjectPets.entities.AdvertType;

@RestController
public class AdvertTypeController {

	private AdvertTypeService advertTypeService;

	@Autowired
	public AdvertTypeController(AdvertTypeService advertTypeService) {
		super();
		this.advertTypeService = advertTypeService;
	}

	@PostMapping("/api/1.0/admin/advertTypes/add")
	public Result advertTypeAdd(@Valid @RequestBody AdvertType advertType) {
		return this.advertTypeService.advertTypeAdd(advertType);

	}

	@GetMapping("/api/1.0/all/advertTypes/getAll")
	public Result advertTypeGetAll() {
		return this.advertTypeService.advertTypeGetAll();
	}

	@DeleteMapping("/api/1.0/admin/advertTypes/delete")
	public Result advertTypeDelete(int advertTypeId) {
		return this.advertTypeService.advertTypeDelete(advertTypeId);
	}

	@PutMapping("/api/1.0/admin/advertTypes/update")
	public Result advertTypeUpdate(@Valid @RequestBody AdvertType advertType) {
		return this.advertTypeService.advertTypeUpdate(advertType);
	}
}
