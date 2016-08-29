package com.letsmeet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.letsmeet.model.Forum;
import com.letsmeet.model.User;
import com.letsmeet.service.ForumService;
import com.letsmeet.service.UserService;

@Controller
public class ForumController {

	@Autowired
	ForumService forumservice;
	
	@Autowired
	UserService userservice;
	
	//int forumcreated;
	
	@RequestMapping("/forum")
	public ModelAndView forum(@RequestParam(value="forumcreated",required=false)Integer forumcreated ,HttpServletRequest request)
	{
		Forum forum = new Forum();
		HttpSession session = request.getSession(false);
		User user =(User)session.getAttribute("user");
		ModelAndView mav = new ModelAndView("forum");
		mav.addObject("forums",forum);
		
		//Forum user1=forumservice.getForumByForumId(forum.getForumid());
		int id=user.getUserid();
		User fuser=userservice.getUserById(id);
		
		List<Forum> approvedforums =forumservice.getApprovedForumsByUserID(user.getUserid());
		mav.addObject("forumcreated",forumcreated);
		mav.addObject("forumposters", approvedforums);
		mav.addObject("fuser",fuser);
		forumcreated=0;
		return mav;
	}
	
	@RequestMapping(value="/forum" ,method=RequestMethod.POST )
	public ModelAndView forumpost(@ModelAttribute("forums")Forum forum,HttpServletRequest request,BindingResult result)
	{
		if(result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("forum");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/forum");
		HttpSession session =request.getSession(false);
		User user=(User)session.getAttribute("user");
		forum.setUser(user);
		LocalDateTime j_date = new LocalDateTime();
		forum.setJ_date(j_date);
		forumservice.requestForum(forum);

		Forum user1=forumservice.getForumByForumId(forum.getForumid());
		int id=user1.getUser().getUserid();
		User fuser=userservice.getUserById(id);
		List<Forum> forumposters=forumservice.getApprovedForumsByUserID(user.getUserid());
		mav.addObject("forums",forum);
		mav.addObject("forumposters",forumposters);
		mav.addObject("user",user);
		mav.addObject("fuser",fuser);
		//forumcreated=1;
		mav.addObject("forumcreated",1);
		return mav;		
	}
	
	
}
