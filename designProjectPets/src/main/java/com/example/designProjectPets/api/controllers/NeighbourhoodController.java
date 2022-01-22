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

import com.example.designProjectPets.business.abstracts.NeighbourhoodService;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Neighbourhood;

@RestController
@RequestMapping("/api/1.0/admin/neighbourhoods")
public class NeighbourhoodController {
	
	private NeighbourhoodService neighbourhoodService;

	@Autowired
	public NeighbourhoodController(NeighbourhoodService neighbourhoodService) {
		super();
		this.neighbourhoodService = neighbourhoodService;
	}
	
	@PostMapping("/add")
	public Result neighbourhoodAdd(@Valid @RequestBody Neighbourhood neighbourhood) {
		return this.neighbourhoodService.neighbourhoodAdd(neighbourhood);
		
	}
	
	@GetMapping("/getAll")
	public Result neighbourhoodGetAll() {
		return this.neighbourhoodService.neighbourhoodGetAll();
	}
	
	@DeleteMapping("/delete")
	public Result neighbourhoodDelete(int neighbourhoodId) {
		return this.neighbourhoodService.neighbourhoodDelete(neighbourhoodId);
	}

	@PutMapping("/update")
	public Result neighbourhoodUpdate(@Valid @RequestBody Neighbourhood neighbourhood) {
		return this.neighbourhoodService.neighbourhoodUpdate(neighbourhood);
	}

}
