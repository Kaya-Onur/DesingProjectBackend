package com.example.designProjectPets.core.utilities.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.core.utilities.user.User;
import com.example.designProjectPets.core.utilities.user.UserService;

@Service
public class UserAuthService implements UserDetailsService  {
	
	UserService userService;

	@Autowired
	public UserAuthService(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		User inDb=this.userService.findByEmail(username).getData();
		if(inDb==null){
			throw new UsernameNotFoundException("Kullanıcı bulunamadı");
		}
		return inDb;
	}

}
