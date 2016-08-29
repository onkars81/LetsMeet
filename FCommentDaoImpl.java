package com.letsmeet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.FCommentDao;
import com.letsmeet.model.Comments;
import com.letsmeet.model.FComment;

@Repository
@Transactional
public class FCommentDaoImpl implements FCommentDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public FComment getFCommentById(int fcommentid) {
		Session session = sessionfactory.getCurrentSession(); 
		FComment comment=session.get(FComment.class,fcommentid);
		return comment;
	}

	public List<FComment> getAllFComments() {
		Session session=sessionfactory.getCurrentSession();
		Query query =session.createQuery("from FComment");
				
		List<FComment> comments =query.list();
		return comments;
	}


	public void addComment(FComment comment) {
		sessionfactory.getCurrentSession().save(comment);
	}


	public List<FComment> getCommentsByForumNo(int forumid, int userid) {
		
		Query query =sessionfactory.getCurrentSession().createQuery("from FComment where forumid = ? and userid = ? ");
		query.setInteger(0,forumid);
		query.setInteger(1,userid);
		
		return (List<FComment>) query.list();
	}


	public List<FComment> getCommentsByonlyForumNo(int forumid) {
		
		Query query =sessionfactory.getCurrentSession().createQuery("from FComment where forumid = ? ");
		query.setInteger(0,forumid);
		
		return (List<FComment>) query.list();

	}

}


