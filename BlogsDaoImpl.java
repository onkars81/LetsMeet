package com.letsmeet.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.letsmeet.dao.BlogsDao;
import com.letsmeet.model.Blogs;
import com.letsmeet.model.User;

@Repository
@Transactional
public class BlogsDaoImpl implements BlogsDao {

	@Autowired 
	SessionFactory sessionfactory;
	
	
	public List<Blogs> getAllBlogs()
	{
		Session session=sessionfactory.getCurrentSession();
		Query query =session.createQuery("from Blogs");
		List <Blogs> blogs =query.list();
		return blogs;
	}

	
	public void addBlogs(Blogs blog) {
		
		Session session=sessionfactory.getCurrentSession();
		session.save(blog);
	}

	
	public void removeAllblogs() {
		List<Blogs> blogs = getAllBlogs();

        for (Blogs blog : blogs){
            deleteBlog(blog);
        }
		
	}


	public void deleteBlog(Blogs blog ) {
	sessionfactory.getCurrentSession().delete(blog);
	}



	public List<Blogs> getAllBlogsByUserId(int userid) {
		
		//List <Blogs> blogsbyuser;
		
		Query query =sessionfactory.getCurrentSession().createQuery("from Blogs where userid = ? ");
		query.setInteger(0,userid);
		
		return (List<Blogs>) query.list();
		//Query query=(Query)sessionfactory.getCurrentSession().createCriteria(Blogs.class,username);
				
		//blogsbyuser=query.list();
		
	}

	public Blogs getBlogByUserId(int userid,int blogno)
	{
		Query query =sessionfactory.getCurrentSession().createQuery("from Blogs where userid=? and blogNo=?");
		query.setInteger(0,userid);
		query.setInteger(1,blogno);
		Blogs blog=(Blogs)query.uniqueResult();
		return blog;
	}


	public Blogs getBlogByNo(int blogno) {
		// TODO Auto-generated method stub
		
		Query query =sessionfactory.getCurrentSession().createQuery("from Blogs where blogno = ? ");
		query.setInteger(0,blogno);
		
		return (Blogs) query.uniqueResult();
		
	}


	
	
}
