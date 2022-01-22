package com.example.designProjectPets.core.utilities.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;



public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	UserDao userDao;
	
	public UniqueEmailValidator(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if(this.userDao.findByUserEmail(email)!=null) {
			return false;
		}
		return true;
	}

}