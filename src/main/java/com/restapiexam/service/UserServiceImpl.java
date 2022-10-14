package com.restapiexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restapiexam.dao.UserDao;
import com.restapiexam.entity.User;
import com.restapiexam.service.UserService;


@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDao urepo;

	@Override
	public User addUser(User user) {
		urepo.save(user);
		return null;
	}

	@Override
	public User editUser(User user) {
		urepo.save(user);
		return user;
	}

	@Override
	public User deleteUser(int id) {
		urepo.deleteById(id);
		return null;
	}

	@Override
	public List<User> getUserByName(String name) {
		List<User> u = urepo.getUserByName(name);
		return u;
	}

	@Override
	public User authenticateUser(User user) {

		return urepo.authenticateUser(user);
	}

}
