package com.apicaller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.entity.EmployeeEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class APICaller {
	private String GET_ALL_USERS_url = "http://localhost:8085/employee";

//	private String ADD_EMPLOYEE_url="http://localhost:8085/management/addEmployee";
	public List<EmployeeEntity> getEmployees() throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		EmployeeEntity[] users = null;
		try {
			users = restTemplate.getForObject(GET_ALL_USERS_url, EmployeeEntity[].class);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<EmployeeEntity> list = users == null ? new ArrayList() : Arrays.asList(users);

		return list;

	}

	public void addEmployee(EmployeeEntity employeeEntity) {

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.postForObject(GET_ALL_USERS_url, employeeEntity, EmployeeEntity.class);
		

	}

	public void updateEmployee(EmployeeEntity emp, int employeeId) {
		RestTemplate restTemplate = new RestTemplate();
		final String url = "http://localhost:8085/employee/" + employeeId;

		restTemplate.put(url, emp, EmployeeEntity.class);
	}

	public String fetchAllEmployeesFile() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(GET_ALL_USERS_url, String.class);
	}

	public void delete(int id) {
		String url = "http://localhost:8085/employee/deleteEmployee";
		String varString = (url + "/" + id);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(varString);

	}
}
