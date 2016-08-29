package com.letsmeet.service;

import java.util.List;

import com.letsmeet.model.Forum;
import com.letsmeet.model.User;

public interface ForumService {

	public List<Forum> getAllForums();
	public boolean getAdminApproved(Forum forum);
	public void addForum(Forum forum);
	public void deleteForum(Forum forum);
	public boolean notifyUser(User user,int forumid);
	public void addForumByAdmin(Forum forum,boolean approval);
	public Forum getForumByForumId(int forumid);
	public List<Forum> getForumByUserId(int userid);
	public void requestForum(Forum forum);
	public Forum getUserIdbyForumId(int forumid);
	public List<Forum> getApprovedForumsByUserID(int userid);
	
}