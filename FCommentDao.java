package com.letsmeet.dao;

import java.util.List;


import com.letsmeet.model.FComment;

public interface FCommentDao {

	public FComment getFCommentById(int fcommentid);
	public List<FComment> getAllFComments();
	public void addComment(FComment comment);
	public List<FComment> getCommentsByForumNo(int forumid,int userid);
	public List<FComment> getCommentsByonlyForumNo(int forumid);
}
