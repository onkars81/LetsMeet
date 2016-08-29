package com.letsmeet.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.jni.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.letsmeet.model.Authorities;
import com.letsmeet.model.Blogs;
import com.letsmeet.model.Comments;
import com.letsmeet.model.EmailSender;
import com.letsmeet.model.User;
import com.letsmeet.service.BlogsService;
import com.letsmeet.service.CommentService;
import com.letsmeet.service.UserService;

import oracle.sql.DATE;
import oracle.sql.Datum;

@Controller
public class HomeController {

	   @Autowired
       private UserService userservice;
	   
	   @Autowired
	   private CommentService commentservice;

	   @Autowired
	   private BlogsService blogservice;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@RequestMapping("/home")
	public ModelAndView homepage()
	{
		return new ModelAndView("home");
		
	}
	
	@RequestMapping("/signin")
	public ModelAndView signIn(
			@RequestParam(value="logout",required=false ) String logout,
			@RequestParam(value="error",required=false) String error,
			@RequestParam(value="deactive",required=false) String deactive,
			Model model)
	{
		if(error!=null)
		{
		model.addAttribute("error","Username or Password is invalid");
		}
		if(logout != null)
		{
		model.addAttribute("logout", "You have logged out succesfully");
		}
		if(deactive!=null)
		{
		model.addAttribute("deactive","User is Deactivated");
		}
		
		
		return new ModelAndView("signin");
	}
	
	@RequestMapping(value="/profile")
	public ModelAndView  aboutUs(Principal activeuser,HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("profile");
		User user=userservice.getUserByUsername(activeuser.getName());
		HttpSession session =request.getSession(true);
		List<Blogs> blogg =blogservice.getAllBlogs();
		mav.addObject("bloggers",blogg);
		mav.addObject("user", user);
    	session.setAttribute("user",user);
		return mav;
			
	}
	
	
	@RequestMapping("/article/{blogNo}")
	public ModelAndView  article(@PathVariable("blogNo")int blogno,Model model,HttpServletRequest request)//@ModelAttribute("comment")Comment comment )
	{
		HttpSession session =request.getSession(false);
		User user=(User)session.getAttribute("user");
		
		List<Comments> comments = commentservice.getCommentsByBlogNo(blogno,user.getUserid());
		
		List<Comments> users_comment = commentservice.getCommentByonlyBlogNo(blogno);
		
		ModelAndView mav = new ModelAndView("article");
		
		Blogs blog =blogservice.getBlogByNo(blogno);
		
		Comments commentObject = new Comments();
		mav.addObject("commentList", comments);
		mav.addObject("blog",blog);
		mav.addObject("users_comment", users_comment);
		model.addAttribute("comments",commentObject);
		return mav;
	}
	
	
	
	@RequestMapping(value="/comment/{blogNo}", method=RequestMethod.POST)
	public ModelAndView addCommented(@PathVariable("blogNo")int blogno,@Valid @ModelAttribute("comments") Comments comment,HttpServletRequest request, BindingResult result) throws SQLException
	{
		ModelAndView mav;
		
		HttpSession session =request.getSession(false);
		User user=(User)session.getAttribute("user");
		
		if(result.hasErrors())
		{	mav=new ModelAndView("redirect:/article/"+blogno);
			return mav;
		}
		
		//Blogs blog = blogservice.getBlogByUserId(user.getUserid(),blogno);
		Blogs blog=blogservice.getBlogByNo(blogno);
		Datum comment_date = new oracle.sql.DATE();
		comment.setComment_date(comment_date);
		comment.setBlogs(blog);
		comment.setUsers(user);
		commentservice.addComment(comment);
		mav=new ModelAndView("redirect:/article/"+blogno);
		return mav;
	
	}
	
	    @RequestMapping(value="/register")
	    public String registerUser(Model model){
	        User user = new User();
	        model.addAttribute("user", user);
	        return "registerUser";
	        }

	    Path path=null;
	    
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registerUserPost(@Valid @ModelAttribute("user") User user,HttpServletRequest request, BindingResult result, Model model){
	    	
	    	if(result.hasErrors()){
	        	return "registerUser";
	        }
	        List<User> userList = userservice.getAllUser();

	    	for (int i=0; i< userList.size(); i++){
	    	    if(user.getEmail().equals(userList.get(i).getEmail())){
	    	        model.addAttribute("emailMsg", "Email already exists");
	    	        return "registerUser";
	    	    }

	    	    if(user.getUsername().equals(userList.get(i).getUsername())){
	    	        model.addAttribute("usernameMsg", "Username already exists");
	    	        return "registerUser";
	    	    }
	    	}
	        
	        
	        user.setEnabled(true);
	        userservice.add(user);
	        
	        MultipartFile userImage = user.getImage();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/profileimg/" + user.getUserid() + ".jpg");

	        if(userImage != null && !userImage.isEmpty()){
	            try {
	                userImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("User profile picture saving failed", ex);
	            }
	        }
	        
	        //EmailSender email = new EmailSender();
	        String arr[]= new String[1];
	        arr[0]=user.getEmail();
	        EmailSender.sendMail("onkars81@gmail.com", "hczzvcrphterxksu","Hi "+user.getName()+", Thank you for Registering with LetsMeet !",arr);
	        return "signin";
	        
	    }

	    	    
	    @RequestMapping(value="/posts")
	    public ModelAndView postspost(/*@ModelAttribute("blogs")Blogs blogs,*/HttpServletRequest request)
	    {
	    	ModelAndView mav = new ModelAndView("posts");
	    	HttpSession session = request.getSession(false);
			User user=(User)session.getAttribute("user");
	    	
			List<Blogs> blogg =blogservice.getAllBlogsByUserId(user.getUserid());
			mav.addObject("bloggers",blogg);
			
			Blogs blog = new Blogs();
	    	mav.addObject("blogs", blog);
	    	mav.addObject("user",user);
	    	
	    	return mav;
	    }
	
	    @RequestMapping(value="/posts",method=RequestMethod.POST)
		public ModelAndView posts(@Valid @ModelAttribute("blogs") Blogs blogs,//,@RequestParam("user")User user,
				HttpServletRequest request,BindingResult result )
		{
			ModelAndView mav = new ModelAndView("redirect:/posts");
			HttpSession session = request.getSession(false);
			User user=(User)session.getAttribute("user");
			//User user1 =userservice.getUserByUsername(user.getUsername());
			//System.out.println(user.getUsername());
			Datum bdate = new oracle.sql.DATE();
			blogs.setBdate(bdate);
			blogs.setUser(user);
			
			mav.addObject("user", user);
			
			blogservice.addBlogs(blogs);
						
			return mav;
		}
	    
	    
	    
}


/*@RequestMapping("/forum")
public ModelAndView addComment(Model model)
{
	//Comments comment =new Comments();
	ModelAndView mav = new ModelAndView("forum");
	
	//model.addAttribute("comment",comment);
	return mav;
}*/



/*@RequestMapping("article")
public ModelAndView articleready()
{
	ModelAndView mav = new ModelAndView("article");
	List<Comments> comments = commentservice.getCommentsByBlogNo(blogno);
	
	Blogs blog =blogservice.getBlogByNo(blogno);
	mav.addObject("commentList", comments);
	mav.addObject("blog",blog);
	
	return mav;	
}*/

