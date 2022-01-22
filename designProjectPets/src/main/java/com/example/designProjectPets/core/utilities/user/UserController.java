package com.example.designProjectPets.core.utilities.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.designProjectPets.core.utilities.results.Result;


@RestController
public class UserController {
	
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/api/1.0/all/users/add")
	public Result addUser(@Valid @RequestBody User user) {
		return this.userService.add(user);
		
	}
	@GetMapping("/api/1.0/admin/users/getAll")
	public Result getAllUser() {
		return this.userService.getAllUser();
	}
	
	@DeleteMapping("/api/1.0/admin/users/delete")
	public Result userDelete(int userId) {
		return this.userService.userDelete(userId);
	}
	
	@GetMapping("/api/1.0/all/users/userId")
	public Result getByUser(int userId) {
		return this.userService.findByUserId(userId);
	}
	
	@PutMapping("/api/1.0/all/users/update")
	public Result userUpdate(@Valid @RequestBody User user) {
		return this.userService.userUpdate(user);
	}
	
}

