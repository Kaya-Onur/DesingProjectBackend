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

import com.example.designProjectPets.business.abstracts.AddressService;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Address;

@RestController
@RequestMapping("/api/1.0/admin/addresses")
public class AddressController {

	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@PostMapping("/add")
	public Result addressAdd(@Valid @RequestBody Address address) {
		return this.addressService.addressAdd(address);

	}

	@GetMapping("/getAll")
	public Result addressGetAll() {
		return this.addressService.addressGetAll();
	}

	@DeleteMapping("/delete")
	public Result addressDelete(int addressId) {
		return this.addressService.addressDelete(addressId);
	}

	@PutMapping("/update")
	public Result addressUpdate(@Valid @RequestBody Address address) {
		return this.addressService.addressUpdate(address);
	}

}
