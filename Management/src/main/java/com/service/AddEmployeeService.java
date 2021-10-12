package com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicaller.APICaller;
import com.entity.EmployeeEntity;

@Service
public class AddEmployeeService {
	@Autowired
	APICaller apiCaller;

	public void addEmployee(String code, String name, String location, String email, Date dob) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmployeeCode(Integer.parseInt(code));
		entity.setEmployeeName(name);
		entity.setLocation(location);
		entity.setEmail(email);
		entity.setDate(dob);
		apiCaller.addEmployee(entity);

	}

}
