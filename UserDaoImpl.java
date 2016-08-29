package com.letsmeet.dao.impl;



import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.UserDao;
import com.letsmeet.model.Authorities;
import com.letsmeet.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionfactory; 
	
	
	public User getUserById(int userId) {
		
		 Session session = sessionfactory.getCurrentSession();
	        return (User) session.get(User.class, userId);
	    
	}

	public void add(User user) {
	
		// TODO Auto-generated method stub
		
		Session session =sessionfactory.getCurrentSession();
		
		Authorities auth = new Authorities();
		auth.setAuthorities("ROLE_USER");
		auth.setUsername(user.getUsername());
		session.save(auth);
		session.save(user);
		
	}


	public List<User> getAllUser() {
		Session session = sessionfactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();

        return userList;
	}

	public List<User> getAllSetOfUsers()
	{
		Session session = sessionfactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList =query.list();
		return userList;
	}

	public User getUserByUsername(String name) {
		
		Session session=sessionfactory.getCurrentSession();
		Query query =session.createQuery("from User where username= ? ");
		query.setString(0,name);
		
		return (User) query.uniqueResult();
	}


	public void deleteUser(User userid)
	{
		Session session=sessionfactory.getCurrentSession();
		userid.setEnabled(false);
		session.saveOrUpdate(userid);
		session.flush();
	}
	
}
