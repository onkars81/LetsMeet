package com.letsmeet.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.letsmeet.model.FriendId;
import com.letsmeet.model.Relationship;
import com.letsmeet.model.User;
import com.letsmeet.service.ContactService;
import com.letsmeet.service.UserService;

@Controller
public class ContactController {

	
	@Autowired
	UserService userservice;

	@Autowired
	ContactService contactservice;
	
	@RequestMapping("/contacts")
	public ModelAndView  contactUs(@RequestParam(value="status",required=false)Relationship.Status statuscode)
	{
		List<User> users=userservice.getAllUser();
		if(Relationship.Status.PENDING==statuscode)
		{
			ModelAndView mav = new ModelAndView("contactlist");
			mav.addObject("requests",users);
			//mav.addObject("status", Relationship.status.ACCEPTED);	
			return mav;
		}
		else
		{
		ModelAndView mav = new ModelAndView("contactlist");
		mav.addObject("requests",users);
		return mav;
		}
	}
	
	@RequestMapping("/contacts/addfriend/{userid}")
	public ModelAndView  contactUs(@PathVariable("userid")int userid,HttpServletRequest request,@RequestParam(value="status" ,required=false) Relationship.Status stat)
	{
			
		ModelAndView mav = new ModelAndView("redirect:/contacts");
		//List<User> users=userservice.getAllUser();
		HttpSession session =request.getSession(false);
		User curruser=(User)session.getAttribute("user");
		User user=userservice.getUserById(userid);
		Relationship rs= new Relationship();
		FriendId fr = new FriendId();
		fr.setUser_one_id(curruser);
		fr.setUser_two_id(user);
		rs.setFriendid(fr);
		rs.setStatus(Relationship.Status.PENDING);
		rs.setAction_user_id(curruser);
		mav.addObject("status",Relationship.Status.PENDING);
		contactservice.addfriend(rs);
		return mav;
	}
	
}
