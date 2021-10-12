package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apicaller.APICaller;
import com.entity.EmployeeEntity;
import com.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;
	@Autowired
	APICaller apiCaller;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		if (userName == null || userName.equals("") || password == null || password.equals("")) {
			model.setViewName("login.jsp");
			return model;
		} else {
			String view = service.logIn(userName, password);
			if (!view.equals("login.jsp")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("uName", userName);
				List<EmployeeEntity> list = apiCaller.getEmployees();
				model.addObject("list", list);
			}

			model.setViewName(view);
		}

		return model;
	}

}
