package com.letsmeet.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.ContactDao;
import com.letsmeet.model.Relationship;
import com.letsmeet.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	ContactDao contactdao;
	
	@Transactional
	public void addfriend(Relationship rs) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		contactdao.addfriend(rs);
		tx.commit();
	}

}
