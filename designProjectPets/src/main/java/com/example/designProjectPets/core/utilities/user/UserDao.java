package com.example.designProjectPets.core.utilities.user;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUserEmail(String email);
	User getByuserId(int userId);

}
