package com.example.designProjectPets.core.utilities.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	

	@Override
	public Result add(User user) {
		user.setUserPassword(this.passwordEncoder.encode(user.getPassword()));
		user.setUserStatus(true);
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}


	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult(this.userDao.findByUserEmail(email),"Veri getirildi.");
	}


	@Override
	public DataResult<List<User>> getAllUser() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Veri listelendi");
	}


	@Override
	public Result userDelete(int userId) {
		User user=this.userDao.getById(userId);
		user.setUserStatus(false);
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı silindi");
	}


	@Override
	public DataResult<User> findByUserId(int userId) {
		return new SuccessDataResult<User>(this.userDao.getByuserId(userId),"Kullanıcı listelendi" );
	}


	@Override
	public Result userUpdate(User user) {
		user.setUserPassword(this.passwordEncoder.encode(user.getUserPassword()));
		this.userDao.save(user);
		return new SuccessDataResult<User>(this.userDao.save(user),"Kullanıcı güncellendi");
	}


	
}

