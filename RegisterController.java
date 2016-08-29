package com.letsmeet.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.letsmeet.model.User;
import com.letsmeet.service.UserService;


public class RegisterController {

   /*@Autowired
    private UserService userservice;

    @RequestMapping(value="/register")
    public String registerUser(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "registerUser";
    }

    Path path=null;
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUserPost(@Valid @ModelAttribute("user") User user,HttpServletRequest request, BindingResult result, Model model){
    	
    	ModelAndView mav;
        if(result.hasErrors()){
        	mav=new ModelAndView("registerUser");
        	return mav;
        }

        
        MultipartFile userImage = user.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/images/" + user.getUserid() + ".jpg");

        if(userImage != null && !userImage.isEmpty()){
            try {
                userImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("User profile picture saving failed", ex);
            }
        }

        user.setEnabled(true);
        userservice.add(user);
        mav=new ModelAndView("profile");
        return mav;
        
    }

	
	
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
}*/


}