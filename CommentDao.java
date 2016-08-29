package com.letsmeet.dao;

import java.util.List;
import java.util.Set;

import com.letsmeet.model.Comments;
import com.letsmeet.model.User;

public interface CommentDao {

	public Comments getCommentById(int commentid);
	public List<Comments> getAllComments();
	public void addComment(Comments comment);
	public List<Comments> getCommentsByBlogNo(int blogNo,int userid);
	public List<Comments> getCommentsByonlyBlogNo(int blogNo);

}
