package com.letsmeet.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.CommentDao;
import com.letsmeet.dao.FCommentDao;
import com.letsmeet.model.Comments;
import com.letsmeet.model.FComment;
import com.letsmeet.service.FCommentService;

@Service
public class FCommentServiceImpl implements FCommentService {

	 	@Autowired
		private SessionFactory sessionfactory;
		
		@Autowired
		FCommentDao fcommentdao; 
		
	
	@Transactional
	public FComment getFCommentById(int fcommentid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		FComment comments=fcommentdao.getFCommentById(fcommentid); 
		tx.commit();
		return comments;
	}

	@Transactional
	public List<FComment> getAllFComments() {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<FComment> comments =fcommentdao.getAllFComments();
		tx.commit();
		return comments;
	}

	@Transactional
	public void addComment(FComment comment) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		fcommentdao.addComment(comment);
		tx.commit();
	}

	@Transactional
	public List<FComment> getCommentsByForumNo(int forumid, int userid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<FComment> comments=fcommentdao.getCommentsByForumNo(forumid, userid);
		tx.commit();
		return comments;
	}

	@Transactional
	public List<FComment> getCommentsByonlyForumNo(int forumid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<FComment> comments=fcommentdao.getCommentsByonlyForumNo(forumid);
		tx.commit();
		return comments;
	}

}
