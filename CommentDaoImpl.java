package com.letsmeet.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.CommentDao;
import com.letsmeet.model.Blogs;
import com.letsmeet.model.Comments;
import com.letsmeet.model.User;

import oracle.sql.DATE;
import oracle.sql.Datum;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public Comments getCommentById(int commentid) {
	
		Session session = sessionfactory.getCurrentSession(); 
		Comments comment=session.get(Comments.class,commentid);
		return comment;
	
	}

	public List<Comments> getAllComments() {
	
		Session session=sessionfactory.getCurrentSession();
		Query query =session.createQuery("from Comments");
				
		List<Comments> comments =query.list();
		return comments;
	}

	public void addComment(Comments comment) 
	{
		
		sessionfactory.getCurrentSession().save(comment);

//		Datum comment_date;
//		try {
//			comment_date = DATE.getCurrentDate();
//			comment.setComments_date(comment_date);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		}

	public List<Comments> getCommentsByBlogNo(int blogNo,int userid)
	{
		
		Query query =sessionfactory.getCurrentSession().createQuery("from Comments where blogNo = ? and userid = ? ");
		query.setInteger(0,blogNo);
		query.setInteger(1,userid);
		
		return (List<Comments>) query.list();
		
	}

	
	public List<Comments> getCommentsByonlyBlogNo(int blogNo)
	{
		Query query =sessionfactory.getCurrentSession().createQuery("from Comments where blogNo = ? ");
		query.setInteger(0,blogNo);
		
		return (List<Comments>) query.list();
		
	}

	
	
}
