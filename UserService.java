package com.letsmeet.service;

import java.util.List;
import java.util.Set;

import com.letsmeet.model.User;

public interface UserService {
	public User getUserById(int userId);
	public void add(User user);
	public User getUserByUsername(String name);
	public List<User> getAllUser();
	public List<User> getAllSetOfUsers();
	public void deleteUser(User userid);
}
