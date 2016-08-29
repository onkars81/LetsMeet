package com.letsmeet.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.ForumDao;
import com.letsmeet.model.Blogs;
import com.letsmeet.model.Forum;
import com.letsmeet.model.User;
import com.letsmeet.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	ForumDao forumdao;
	
	@Transactional
	public List<Forum> getAllForums() {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Forum> forums=forumdao.getAllForums();
		tx.commit();
		return forums;
	}

	@Transactional
	public boolean getAdminApproved(Forum forum) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		boolean approval=forumdao.getAdminApproved(forum);
		tx.commit();
		return approval;
	}

	@Transactional
	public void addForum(Forum forum) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		forumdao.addForum(forum);
		tx.commit();
		
	}

	@Transactional
	public void deleteForum(Forum forum) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		forumdao.deleteForum(forum);
		tx.commit();
	}

	@Transactional
	public boolean notifyUser(User user, int forumid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		boolean approv=forumdao.notifyUser(user, forumid);
		tx.commit();
		return approv;
	}

	@Transactional
	public void addForumByAdmin(Forum forum, boolean approval) {
	
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		forumdao.addForumByAdmin(forum, approval);
		tx.commit();
	}

	@Transactional
	public Forum getForumByForumId(int forumid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Forum forum =forumdao.getForumByForumId(forumid);
		tx.commit();
		return forum;
	}

	@Transactional
	public List<Forum> getForumByUserId(int userid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Forum> forum=forumdao.getForumByUserId(userid);
		tx.commit();
		return forum;
	}

	@Transactional
	public void requestForum(Forum forum) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		forumdao.requestForum(forum);
		tx.commit();
	}

	@Transactional
	public List<Forum> getApprovedForumsByUserID(int userid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Forum> forums =forumdao.getApprovedForumsByUserID(userid);
		tx.commit();
		return forums;
	}

	@Transactional
	public Forum getUserIdbyForumId(int forumid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Forum user =forumdao.getUserIdbyForumId(forumid);
		tx.commit();
		return user;
	}

}
