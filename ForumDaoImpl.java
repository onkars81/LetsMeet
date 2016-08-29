package com.letsmeet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.ForumDao;
import com.letsmeet.model.Forum;
import com.letsmeet.model.User;

@Repository
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionfactory;
	
	
	public List<Forum> getAllForums() {
			Session session= sessionfactory.getCurrentSession();	
			Query query =session.createQuery("from Forum where approve=0");
			List<Forum> forums=query.list();
			return forums;
	}
	
	
	public boolean getAdminApproved(Forum forum) {
		
		boolean approved=forum.isApprove();	
		return approved;
	}

	public void requestForum(Forum forum)
	{
		forum.setApprove(false);
		sessionfactory.getCurrentSession().save(forum);
		//addForumByAdmin(forum,false);
	}

	public void addForum(Forum forum) {
		
		sessionfactory.getCurrentSession().save(forum);
	
	}

	public void deleteForum(Forum forum) {
		sessionfactory.getCurrentSession().delete(forum);
	}

	public boolean notifyUser(User user, int forumid) {
		
		return true;
	}

	public void addForumByAdmin(Forum forum,boolean approval)
	{
		forum.setApprove(approval);	
		sessionfactory.getCurrentSession().saveOrUpdate(forum);
	}

	public List<Forum> getApprovedForumsByUserID(int userid)
	{
		Session session =sessionfactory.getCurrentSession();
		Query query =session.createQuery("from Forum where userid=? and approve = 1");
		query.setInteger(0,userid);
		return (List<Forum>)query.list();
		
	}
	
	public Forum getForumByForumId(int forumid) {
		Session session=sessionfactory.getCurrentSession();
		Query query = session.createQuery("from Forum where forumid= ?");
		query.setInteger(0, forumid);
		Forum forum = (Forum)query.uniqueResult();
		return  forum;
	}

	public List<Forum> getForumByUserId(int userid) {
		
		Session session=sessionfactory.getCurrentSession();
		Query query = session.createQuery("from Forum where userid= ?");
		query.setInteger(0, userid);
		List<Forum> forum = query.list();
		return  forum;
		}

	public Forum getUserIdbyForumId(int forumid) {
		Session session=sessionfactory.getCurrentSession();
		//Query query=session.createQuery("select userid from Forum where forumid=?");
		SQLQuery query=session.createSQLQuery("select * from Forum where forumid=?");
		//SQLQuery query = session.createSQLQuery();
		query.addEntity(Forum.class);
		//query.setParameter("forumid",forumid);
		query.setInteger(0,forumid);
				
		Forum users=(Forum)query.uniqueResult();
		return users;//.get(0);
	
	}


}
