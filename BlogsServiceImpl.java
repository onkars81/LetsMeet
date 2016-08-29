package com.letsmeet.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.BlogsDao;
import com.letsmeet.model.Blogs;
import com.letsmeet.model.Comments;
import com.letsmeet.service.BlogsService;

@Service
public class BlogsServiceImpl implements BlogsService{

	@Autowired
	SessionFactory sessionfactory;
	
	@Autowired
	BlogsDao blogsdao;
	
	@Transactional
	public List<Blogs> getAllBlogs() {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Blogs> blogs=blogsdao.getAllBlogs();
		tx.commit();
		return blogs;
	
	}

	@Transactional
	public void addBlogs(Blogs blog) {
	
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		blogsdao.addBlogs(blog);
		tx.commit();
		
	}

	@Transactional
	public void removeAllblogs() {
		
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		blogsdao.removeAllblogs();
		tx.commit();
		
	}

	@Transactional
	public void deleteBlog(Blogs blog) {
	
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		blogsdao.deleteBlog(blog);
		tx.commit();
		
	}

	@Transactional
	public List<Blogs> getAllBlogsByUserId(int userid) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		List<Blogs> blogs=blogsdao.getAllBlogsByUserId(userid);
		tx.commit();
		return blogs;
		}


	@Transactional
	public Blogs getBlogByNo(int blogno) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Blogs blogs=blogsdao.getBlogByNo(blogno);
		tx.commit();
		return blogs;
		
	}

	@Transactional
	public Blogs getBlogByUserId(int userid, int blogno) {
		Session session =sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Blogs blogs=blogsdao.getBlogByUserId(userid, blogno);
		tx.commit();
		
		return blogs;
	}

	
	
	
}
