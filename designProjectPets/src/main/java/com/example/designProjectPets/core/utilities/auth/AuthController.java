package com.example.designProjectPets.core.utilities.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.designProjectPets.core.utilities.shared.CurrentUser;
import com.example.designProjectPets.core.utilities.shared.Views;
import com.example.designProjectPets.core.utilities.user.User;
import com.example.designProjectPets.core.utilities.user.UserService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class AuthController {

	UserService userService;

	@Autowired
	public AuthController(UserService userService) {
		super();
		this.userService = userService;
	}
			
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
		return ResponseEntity.ok(user);
	}
}
