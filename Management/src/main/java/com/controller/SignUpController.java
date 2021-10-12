package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.SignUpService;

@Controller
public class SignUpController {
	@Autowired
	SignUpService service;

	@RequestMapping(path = "/signUp")
	public ModelAndView register(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		ModelAndView model = new ModelAndView();
		
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			model.setViewName("signup.jsp");
		} else {
			service.signUp(userName, password);
			model.setViewName("login.jsp");
		}
		return model;

	}

}
