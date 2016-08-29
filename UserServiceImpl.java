package com.letsmeet.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.letsmeet.dao.UserDao;
import com.letsmeet.model.Authorities;
import com.letsmeet.model.User;
import com.letsmeet.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	UserDao userdao;
	/*
	@Autowired
	public UserServiceImpl(SessionFactory sessionfactory)
	{
	this.sessionfactory=sessionfactory;
	}*/
	
	@Transactional
	public User getUserById(int userId) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		User user=userdao.getUserById(userId);
    	tx.commit();
		return user;
	}

	@Transactional
	public void add(User user) {
	
		Session session = sessionfactory.openSession();
		Transaction tx =session.beginTransaction();
		tx.begin();
		
		userdao.add(user);
		tx.commit();
	}

	@Transactional
	public List<User> getAllUser() {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List <User> user=userdao.getAllUser();
		tx.commit();
    	return user;
	}

	@Transactional
	public User getUserByUsername(String name) {
	Session session =sessionfactory.openSession();
	Transaction tx =session.beginTransaction();
	tx.begin();
	User user =userdao.getUserByUsername(name);
	tx.commit();	
	return user;
	}

	@Transactional
	public List<User> getAllSetOfUsers()
	{
		
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<User> users=userdao.getAllSetOfUsers();
		tx.commit();
    	return users;
	}
	
	@Transactional
	public void deleteUser(User userid)
	{
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		userdao.deleteUser(userid);
		tx.commit();
  
	}
	
}
