package com.example.designProjectPets.core.utilities.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;


@Service
public class UserRoleManager implements UserRoleService {

	private UserRoleDao userRoleDao;
	

	
	@Autowired
	public UserRoleManager(UserRoleDao userRoleDao) {
		super();
		this.userRoleDao = userRoleDao;

	}
	
	@Override
	public DataResult<List<UserRole>> getAllRoles() {
		return new SuccessDataResult<List<UserRole>>(this.userRoleDao.findAll());
	}

}