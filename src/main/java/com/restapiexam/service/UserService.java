package com.restapiexam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapiexam.entity.User;


@Service
public interface UserService {

	public User addUser(User user);

	public User editUser(User user);

//	public void editUser(User user, int id);

	public User deleteUser(int id);

	public List<User> getUserByName(String name);

	public User authenticateUser(User user) ;

}
