package com.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.EmployeeEntity;
import com.entity.UserEntity;
import com.apicaller.APICaller;
import com.dao.UserDao;

@Service
public class LoginService {
	@Autowired
	UserDao userdao;

	public String logIn(String userName, String password) throws Exception {
		UserEntity user = userdao.getUser(userName);
		String encryptPassword = getEncrpytedPassword(password);
		if (user.getUserName().equals(userName) && user.getPassword().equals(encryptPassword)) {

			return "listing.jsp";
		} else {

			return "login.jsp";
		}
	}

	public String getEncrpytedPassword(String string) {
		return (String) Base64.getEncoder().encodeToString(string.getBytes());

	}
}
