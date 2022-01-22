package com.example.designProjectPets.core.utilities.user;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;



public interface UserRoleService {
	
	DataResult<List<UserRole>> getAllRoles();
}
