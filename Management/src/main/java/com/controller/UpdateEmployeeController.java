package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apicaller.APICaller;
import com.entity.EmployeeEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.service.UpdateService;

@Controller
public class UpdateEmployeeController {
	@Autowired
	UpdateService service;
	@Autowired
	APICaller apiCaller;

	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@RequestParam("employeeCode") int code, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("uName") == null) {
			model.setViewName("login.jsp");
		} else {
			
			model.addObject("employeeCode", code);
			model.setViewName("editPage.jsp");
		}
		return model;

	}

	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("employeeCode") String code,
			@RequestParam("employeeName") String name, @RequestParam("employeeLocation") String location,
			@RequestParam("employeeEmail") String email,
			@RequestParam("employeeDOB") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dob,
			HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("uName") == null) {
			model.setViewName("login.jsp");
		} else {
			service.addEmployee(code, name, location, email, dob);
			List<EmployeeEntity> list = apiCaller.getEmployees();
			model.addObject("list", list);
			model.setViewName("listing.jsp");
		}
		return model;

	}

	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public ModelAndView editEmployee(@RequestParam("employeeCode") int code, HttpServletRequest request)
			throws JsonMappingException, JsonProcessingException {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("uName") == null) {
			model.setViewName("login.jsp");
		} else {
			try {
				apiCaller.delete(code);
			} catch (Exception e) {

			} finally {
				List<EmployeeEntity> list = apiCaller.getEmployees();
				model.addObject("list", list);
				model.setViewName("listing.jsp");
			}
		}
		return model;

	}

}
