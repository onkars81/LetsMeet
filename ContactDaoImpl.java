package com.letsmeet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.ContactDao;
import com.letsmeet.model.Relationship;

@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {

	@Autowired 
	SessionFactory sessionfactory;
	
	public void addfriend(Relationship rs) {
		Session session=sessionfactory.getCurrentSession();
		session.save(rs);
		session.flush();
	}
	
}
