package com.helloworld.service;

import java.util.List;

import com.helloworld.dao.UserDaoImpl;
import com.helloworld.model.User;

public class UserService {

	private static UserDaoImpl userDao;
	
	public UserService() {
		userDao= new UserDaoImpl();
	}

	public void save(User entity) {
		userDao.openCurrentSessionwithTransaction();
		userDao.save(entity);
		userDao.closeCurrentSessionwithTransaction();
	}
	public void update(User entity) {
		userDao.openCurrentSessionwithTransaction();
		userDao.update(entity);
		userDao.closeCurrentSessionwithTransaction();
	}
	public void delete(User entity) {
		userDao.openCurrentSessionwithTransaction();
		userDao.delete(entity);
		userDao.closeCurrentSessionwithTransaction();
	}
	public User findById (Long id) {
		userDao.openCurrentSession();
		User user=userDao.findById(id);
		userDao.closeCurrentSession();
		return user;
	}
	public List<User> findAll() {
		userDao.openCurrentSession();
		List<User> users=userDao.findAll();
		userDao.closeCurrentSession();
		return users;
	}
	public void deleteAll() {
		userDao.openCurrentSessionwithTransaction();
		userDao.deleteAll();
		userDao.closeCurrentSessionwithTransaction();
	}
}
