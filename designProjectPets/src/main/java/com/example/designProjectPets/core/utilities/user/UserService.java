package com.example.designProjectPets.core.utilities.user;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;


public interface UserService {
	

	 Result add(User user);
	 DataResult<User> findByEmail(String email);
	 DataResult<User> findByUserId(int userId);
	 DataResult<List<User>> getAllUser();
	 Result userDelete(int userId);
	 
	 Result userUpdate(User user);
	 

}
