package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apicaller.APICaller;
import com.entity.EmployeeEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.service.AddEmployeeService;

@Controller
public class AddEmployeeController {
	@Autowired
	APICaller apiCaller;
	@Autowired
	AddEmployeeService service;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("uName") == null) {
			model.setViewName("login.jsp");
		} else {
			model.setViewName("addEmployee.jsp");
		}
		return model;
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("employeeCode") String code,
			@RequestParam("employeeName") String name, @RequestParam("employeeLocation") String location,
			@RequestParam("employeeEmail") String email,
			@RequestParam("employeeDOB") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dob,
			HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("uName") == null) {
			model.setViewName("login.jsp");
		} else {
			if (code == null || name == null || location == null || email == null || dob == null) {
				System.out.println("add Employee");
				model.setViewName("addEmployee.jsp");
			} else {
				System.out.println("listing");
				service.addEmployee(code, name, location, email, dob);
				List<EmployeeEntity> list = apiCaller.getEmployees();
				model.addObject("list", list);
				model.setViewName("listing.jsp");
			}
		}
		return model;
	}

}
