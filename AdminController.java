package com.letsmeet.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letsmeet.model.Forum;
import com.letsmeet.model.User;
import com.letsmeet.service.ForumService;
import com.letsmeet.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminController
{
	@Autowired
	ForumService forumservice;
	
	@Autowired
	UserService userservice; 
	
	@RequestMapping(value="/adminpage")
	public ModelAndView adminpage(Principal admin)
	{
		
		List<Forum> forumrequests= forumservice.getAllForums();
		
		ModelAndView mav = new ModelAndView("adminpage");
		mav.addObject("forumrequests",forumrequests);
		return mav;
	}
	
	@RequestMapping(value="/deleteforum/{forumid}")
	public ModelAndView acceptforumpage(@PathVariable("forumid")int forumid )
	{
		ModelAndView mav = new ModelAndView("redirect:/admin/adminpage");
		Forum forum = forumservice.getForumByForumId(forumid);
		forumservice.deleteForum(forum);
		
		List<Forum> forumrequests= forumservice.getAllForums();
		
		mav.addObject("forumrequests",forumrequests);
		return mav;
	}
	
	
	@RequestMapping("/acceptforum/{forumid}")
	public ModelAndView decline(@PathVariable("forumid")int forumid)
	{
		ModelAndView mav = new ModelAndView("redirect:/admin/adminpage");
		Forum forum =forumservice.getForumByForumId(forumid);
		forumservice.addForumByAdmin(forum, true);
		
		List<Forum> forumrequests= forumservice.getAllForums();
		mav.addObject("forumrequests",forumrequests);
		return mav;
	}
	
	@RequestMapping(value="/allusers")
	public ModelAndView UserManagement()
	{
		ModelAndView mav = new ModelAndView("allusers");
		List<User> pageusers=userservice.getAllUser();
		mav.addObject("pageusers",pageusers);
		return mav;
	}
	
	@RequestMapping(value="/block/{userid}")
	public ModelAndView UserManagement(@PathVariable("userid") int userid)
	{
		ModelAndView mav = new ModelAndView("allusers");
		User user =userservice.getUserById(userid);
		userservice.deleteUser(user);
		//user.setEnabled(false);
		
		List<User> pageusers=userservice.getAllUser();
		mav.addObject("pageusers",pageusers);
		return mav;
	}
	
}
