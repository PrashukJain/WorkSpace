package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.LoginService;

@Controller
public class LoginController {
	@Autowired
LoginService service;
	 @RequestMapping(path = "/login", method = RequestMethod.POST)
	    public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("password") String password,
	            HttpServletRequest request)
	            throws Exception {
		 System.out.println("In login controller");
	        ModelAndView model = new ModelAndView();
	        if (userName == null || userName.equals("") || password == null || password.equals("")) {
	            model.setViewName("login.jsp");
	        } else {
	            String view = service.logIn(userName, password);
	            model.addObject("uName", userName);
	            if (view.equals("welcomePage.jsp")) {
	                HttpSession session = request.getSession(true);
	                session.setAttribute("user", userName);

	            }

	            model.setViewName(view);
	        }
	        return model;
	    }

}
