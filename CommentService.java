package com.letsmeet.service;

import java.util.List;
import java.util.Set;

import com.letsmeet.model.Comments;
import com.letsmeet.model.User;

public interface CommentService {
	public Comments getCommentById(int commentid);
	public List<Comments> getAllComments();
	public void addComment(Comments comment);
	public List<Comments> getCommentsByBlogNo(int blogNo,int userid);
	public List<Comments> getCommentByonlyBlogNo(int blogNo);

}
