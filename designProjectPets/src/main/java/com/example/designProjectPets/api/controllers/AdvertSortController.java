package com.example.designProjectPets.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.designProjectPets.business.abstracts.AdvertSortService;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.AdvertSort;


@RestController
public class AdvertSortController {


	private AdvertSortService advertSortService;

	
	@Autowired
	public AdvertSortController(AdvertSortService advertSortService) {
		super();
		this.advertSortService = advertSortService;
	}

	@PostMapping("/api/1.0/admin/advertSorts/add")
	public Result advertTypeAdd(@Valid @RequestBody AdvertSort advertSort) {
		return this.advertSortService.advertSortAdd(advertSort);

	}

	@GetMapping("/api/1.0/all/advertSorts/getAll")
	public Result advertTypeGetAll() {
		return this.advertSortService.advertSortGetAll();
	}

	@DeleteMapping("/api/1.0/admin/advertSorts/delete")
	public Result advertTypeDelete(int advertSortId) {
		return this.advertSortService.advertSortDelete(advertSortId);
	}

	@PutMapping("/api/1.0/admin/advertSorts/update")
	public Result advertTypeUpdate(@Valid @RequestBody AdvertSort advertSort) {
		return this.advertSortService.advertSortUpdate(advertSort);
	}
}
