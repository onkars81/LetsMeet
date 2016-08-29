package com.letsmeet.service;

import java.util.List;

import com.letsmeet.model.Blogs;

public interface BlogsService {

	
	public List<Blogs> getAllBlogs();
	public void addBlogs(Blogs blog);
	public void removeAllblogs();
	public void deleteBlog(Blogs blog);
	public List<Blogs> getAllBlogsByUserId(int userid);
	public Blogs getBlogByNo(int blogno);
	public Blogs getBlogByUserId(int userid,int blogno);
}
