package com.helloworld.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.helloworld.model.User;
import com.helloworld.service.UserService;

@Controller
public class UserAddController {

	@RequestMapping("/userRegistrationForm")
	public ModelAndView getUserRegistrationForm() {
		ModelAndView mv=new ModelAndView("userRegistrationForm");
		mv.addObject("userEntity", new User());
		return mv;
	}
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute User u) {
		ModelAndView mv=new ModelAndView("userList");
		
		UserService userService = new UserService();
		u.setRegisterDate(new Date());
		userService.save(u);
		mv.addObject("userList", userService.findAll());
		
		return mv;
	}
}
