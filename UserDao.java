package com.letsmeet.dao;

import java.util.List;
import java.util.Set;

import com.letsmeet.model.User;

public interface UserDao {

	public void add(User user);
	public User getUserById(int userId);
	public List<User> getAllUser();
	public User getUserByUsername(String name);
	public List<User> getAllSetOfUsers();
	public void deleteUser(User userid);
}
 