package com.example.designProjectPets.core.utilities.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designProjectPets.core.utilities.results.Result;


@RestController
public class UserRoleController {
	UserRoleService userRoleService;

	@Autowired
	public UserRoleController(UserRoleService userRoleService) {
		super();
		this.userRoleService=userRoleService;
	}
	
	@GetMapping("/api/1.0/admin/userRoles/getAll")
	public Result getAllUser() {
		return this.userRoleService.getAllRoles();
	}
	
	
}
