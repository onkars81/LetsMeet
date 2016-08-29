package com.letsmeet.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.CommentDao;
import com.letsmeet.model.Comments;
import com.letsmeet.model.User;
import com.letsmeet.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Autowired
	CommentDao commentdao; 
	
	@Transactional
	public Comments getCommentById(int commentid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Comments comments =commentdao.getCommentById(commentid);
		tx.commit();
		return comments;
	}

	@Transactional
	public List<Comments> getAllComments() {
		
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Comments> comments =commentdao.getAllComments();
		tx.commit();
		return comments;
	}

	@Transactional
	public void addComment(Comments comment) {
		
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		commentdao.addComment(comment);
		tx.commit();
	}

	@Transactional
	public List<Comments> getCommentsByBlogNo(int blogNo,int userid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Comments> comments =commentdao.getCommentsByBlogNo(blogNo,userid);
		tx.commit();
		return comments;
	}

	@Transactional
	public List<Comments> getCommentByonlyBlogNo(int blogNo) {
	
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Comments> comments =commentdao.getCommentsByonlyBlogNo(blogNo);
		tx.commit();
		return comments;
	}

	
}
