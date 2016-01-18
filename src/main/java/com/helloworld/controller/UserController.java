package com.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.helloworld.model.User;
import com.helloworld.service.UserService;

public class UserController implements Controller {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("in UserController");
		ModelAndView mv= new ModelAndView("userList");
		List<User> ul=this.userService.findAll();
		mv.addObject("userList",ul);
		return mv;
	}

}
